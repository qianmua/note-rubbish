package _java_io_;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/11  15:55
 * @description :
 */
public class Demo3File {

    /*
    *
    * 字符流 读取 有问题
    * // 可能会乱码
    *
    * 使用字节流读取中文字符
    *
    * GBK 中文占用 2个字节
    * UTF-8 占用 3个字节
    *
    *
    * Reader \ Writer
    *
    * 字符输入 输出 流
    *
    *
    * Reader
    * 读取 单个字符
    * read(char[])
    * 读取多个
    *
    * BufferReader / FileInputReader
    *
    * */

    // 字符流
    static void m1() throws IOException {
        //FileReader (是 FileInputReader 的子类)
        FileReader reader = new FileReader("demo.txt");
        // 读取单个字符
        int read = reader.read();

        reader.close();
        //while 读取有效字符个数


        // 输出流
        // FileWriter
        // 写入字符
        FileWriter writer = new FileWriter("demo1.txt" );
        writer.write(97);
        // 把缓冲区 刷新到文件中
        writer.flush();
        writer.close();


        // flush close
        // 都可以 刷新缓冲区
        // flush 可以继续使用
        // close 就关闭了



        /*
        * 其他实现方法
        *
        * */


    }
}
