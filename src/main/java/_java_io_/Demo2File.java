package _java_io_;

import java.io.*;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/11  14:23
 * @description :
 */
public class Demo2File {

    /*
    * IO
    *
    *
    * 一切 皆为字节
    *  储存都是二进制流
    *
    * */

    /**
     * output
     * @throws IOException
     */
    static void m1() throws IOException {

        /*
        * 字节输入 输出 流
        *
        * InputStream / outputStream
        *
        * 是所有输入输出 流的超类
        *
        * FileOutputStream //文件字节输出流
        * // 把数据写入 硬盘
        *
        * 写入 数据 到硬盘
        * writer
        * java -> jvm -> os -> 硬盘
        *
        * 使用完 记得清空内存 ， 提高效率
        * */

        FileOutputStream stream = new FileOutputStream("demo.txt");
        // 写入 2进制
        // 文件查看 会自动转为 响应
        // 1-127 是转换为 ascII 表中
        // 其他的 会去查找 系统表 // 中文啥的
        // 注意是写入 二进制
        stream.write(97);
        stream.flush();
        stream.close();

        //字节流续写 换行
        // FileOutputStream 写入 会 覆盖之前写入的数据
        //追加写入
        // 构造方法 参数
        // append 是否追加写
        FileOutputStream stream2 = new FileOutputStream("demo.txt" , true);




    }

    /**
     * input
     * @throws IOException
     */
    static void m2() throws IOException{
        /*
        *
        * 字节输入流
        *
        * InputStream
        *
        * read()读取一个字节
        *
        * read(byte[] byte) 读取指定字节 并且 存在 缓冲区
        *
        * read(byte[] byte , index , end) // 指定 开始 到 结束
        * // 断点 续传
        *
        * 读取数据
        *
        * java -> jvm -> os -> os读取 -> read
        *
        * */

        FileInputStream stream = new FileInputStream("demo.txt");
        // 读取的是 字节数字
        // 需要转换
        // 读取文件中字节 并且返回
        // 组后一个 返回 -1
        // 每次 读取 指针 都会 像后面移动
        int read = stream.read();

        // while读取
        int len = 0;
        while ( (len = stream.read()) != -1){
            System.out.println((char)len);
        }


        stream.close();
    }

    /**
     * 文件复制
     * @throws IOException
     */
    static void m3() throws IOException{
        FileInputStream stream = new FileInputStream("C:\\Users\\HJC\\IdeaProjects\\god-way\\src\\main\\java\\_java_io_\\demo.txt" );
        FileOutputStream stream1 = new FileOutputStream("C:\\Users\\HJC\\IdeaProjects\\god-way\\src\\main\\java\\_java_io_\\demo2.txt" , true);
        int len = 0;
        while ( (len = stream.read()) != -1 )
            stream1.write( len );

        stream1.flush();
        stream1.close();
        stream.close();
    }

    public static void main(String[] args) throws IOException {
        m3();
    }


}
