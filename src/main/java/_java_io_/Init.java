package _java_io_;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/11  13:09
 * @description :
 */
public class Init {

    public static void main(String[] args) throws IOException {
    }
    static void m1() throws IOException{
        File file = new File("C:\\Users\\HJC\\IdeaProjects\\god-way\\src\\main\\java\\_java_io_\\demo.txt");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        writer.write("测试 中文");

        writer.flush();
        writer.close();
    }

    static void m2() throws IOException{
        File file = new File("C:\\Users\\HJC\\IdeaProjects\\god-way\\src\\main\\java\\_java_io_\\demo.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));

        System.out.println(reader.readLine());

        reader.close();
    }
}
