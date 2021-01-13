package _2_demo_.classLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author jinchao.hu
 * @date 2021/1/13  14:16
 * @description : 自定义类加载加载冲突的包 (与UAC 集成 旧版的包排除不掉)
 *
 * 主要为 common-lang 包与 common-lang3包
 * all*.exclude group: 'com.fa.mycim.framework', module: 'mycim-utils'
 *
 */
public class AdvanceLoaderConflictClass extends ClassLoader{
    public AdvanceLoaderConflictClass(){}

    public AdvanceLoaderConflictClass(ClassLoader parent){
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("C:\\Users\\HJC\\.gradle\\caches\\modules-2\\files-2.1\\com.fa.sesa\\sesa-utils\\0.0.8-SNAPSHOT\\beb531eb03ee2386d4b688e3e110ac93ae318b0e\\sesa-utils-0.0.8-SNAPSHOT.jar!\\com\\mycim\\framework\\utils\\lang\\StringUtils.class");
        try {
            byte[] classBytes = getContent(file);
            Class<?> aClass = this.defineClass(name, classBytes, 0, classBytes.length);
            return aClass;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * read class
     * @param file filePath
     * @return class byte
     */
    private byte[] getContent(File file) {
        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            throw new RuntimeException("The file size is too large!");
        }
        byte[] buffer = new byte[(int)length];

        try (FileInputStream fis = new FileInputStream(file) ){
            int offset = 0;
            int num = 0;
            while (offset < buffer.length
                    && (num = fis.read(buffer, offset, buffer.length - offset)) >= 0 ) {
                offset += num;
            }
            if (offset != buffer.length) {
                throw new IOException("read class fail,");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;

    }
}
