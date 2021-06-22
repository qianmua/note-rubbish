package _codebyte_;

import jdk.internal.org.objectweb.asm.ClassReader;

import java.awt.font.TextHitInfo;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.lang.ClassLoader.getSystemClassLoader;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/18  16:27
 */
public class GetByte {

    public static ClassReader getClassReader() throws Exception {

        // com.Application
        String className = TextHitInfo.class.getName();
        // com/Application.class
        String classPath = className.replaceAll("\\.", "/") + ".class";
        String classAbPath = ClassLoader.getSystemResource(classPath).getPath();
        // com/Application_origin.class
        String classAbOriginPath = ClassLoader.getSystemResource(classPath).getPath().replace(".class", "_origin.class");

        // 打印绝对路径
        String path = getSystemClassLoader()
                .getResource(classPath).getPath();
        path = path.substring(6); // remove file:/
        classAbOriginPath = classAbOriginPath.substring(6);
        classAbPath = classAbPath.substring(6);

        path = "./GaussQuery.class";
        classAbOriginPath = "./GaussQuery.class";
        classAbPath = System.getProperty("user.dir") + "/mybatis-plus-sample-quickstart/src/test/java/com/fa/mycim/pms/" + "GaussQuery.class";
        System.out.println("target class :\t" + path);
        // 除了类名 String ,ClassReader 还可以接受byte[] 数组 ,和inputstream
        String type = "bytes";
        // String type = "inputStream";
        // String type = "bytes";
        ClassReader cr = null;

        switch (type) {
            case "name":
                // com.Application.class
                cr = new ClassReader(className);
                break;
            case "inputStream":

                cr = new ClassReader(ClassLoader.getSystemResourceAsStream(classPath));
                break;
            case "bytes":
                String temp = classAbOriginPath;
                if (!Files.exists(Paths.get(classAbOriginPath))) {
                    temp = classAbPath;
                }
                byte[] classbytes;
                // 读取
                try (
                        InputStream inputStream = new FileInputStream(temp);
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                ) {
                    byte[] data = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
                        outputStream.write(data, 0, bytesRead);
                    }
                    outputStream.flush();
                    classbytes = outputStream.toByteArray();
                }
                // 输出到 origin
                try (OutputStream out_origin =
                             Files.newOutputStream(Paths.get(classAbOriginPath), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
                ) {
                    out_origin.write(classbytes, 0, classbytes.length);
                    out_origin.flush();
                }catch (Exception e){
                    e.printStackTrace();
                }

                cr = new ClassReader(classbytes);
        }


        return cr;
    }

    public static void save(Class transform, Class source, byte[] data) {
        String classPath = source.getCanonicalName().replaceAll("\\.", "/") + ".class";
        String sourcePath = getSystemClassLoader().getResource(classPath).getPath();

        // target.class
        String targetPath = sourcePath.replaceAll(source.getSimpleName() + "\\.class",
                transform.getSimpleName() + "_" + source.getSimpleName() + ".class");
        System.out.println("out: " + targetPath);

        String targetText = targetPath.replace("target/classes", "src/main/java")
                .replace(source.getSimpleName() + ".class", source.getSimpleName() + "_bytecode.text");
        if (!Files.exists(Paths.get(targetText).getParent())) {
            targetText = targetPath.replaceAll(source.getSimpleName() + ".class",
                    source.getSimpleName() + "_bytecode.text");

        }
        System.out.println("out: " + targetText);
        // 生成class类
        try (OutputStream out =
                     Files.newOutputStream(Paths.get(targetPath), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
             OutputStream out_origin =
                     Files.newOutputStream(Paths.get(sourcePath), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        ) {
            out.write(data, 0, data.length);
            out.flush();

            out_origin.write(data, 0, data.length);
            out_origin.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 生成bytecode 文件
        try {
            String cmd = "javap -verbose " + targetPath;
            Process exec = Runtime.getRuntime().exec(cmd);
            byte[] bytes = new byte[4096];
            int bytesRead = 0;
            try (InputStream in = exec.getInputStream();
                 OutputStream out =
                         Files.newOutputStream(Paths.get(targetText), StandardOpenOption.CREATE, StandardOpenOption.WRITE);) {
                while ((bytesRead = in.read(bytes, 0, bytes.length)) != -1) {
                    out.write(bytes, 0, bytesRead);
                }
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
