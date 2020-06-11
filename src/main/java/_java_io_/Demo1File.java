package _java_io_;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/11  13:09
 * @description :
 */
public class Demo1File {

    /*
    *
    * file
    * 文件和目录的抽象表示
    * java 中 file 把路径与文件封装到一块
    *
    *
    * file：
    * 创建 文件/文件夹
    * 删除
    * 获取
    * 判断存在
    * 遍历
    * 得到大小
    * // 与操作系统无关
    * // 任何系统都可以调用file
    *
    * */

    /*
    * file 文件
    *
    * directory 文件夹
    *
    * path 路径
    *
    *
    * 相对路径
    *   完整路径
    * 绝对路径
    *   相对于当前项目的根目录
    *
    *
    * */

    public static void main(String[] args) {
        /*
        * file 静态变量
        * */


        //pathSeparator // 路径分隔符 win: ; linux: :
        //pathSeparatorChar // 系统相关路径分割
        System.out.println(File.pathSeparator);


        //Separator //系统默认分割 // 文件 分隔符 win: \ linux /
        //SeparatorChar
        System.out.println(File.separator);



        /*
        * file 构造方法
        * */

        //pathname 路径名称
        // 可以是 文件结尾 也可以是 文件夹
        // 可以是 相对路径 也可以是绝对路径
        // 可以存在 ，也可以不存在
        // 创建只是把字符串封装为file对象 // 不考虑真假
        System.out.println(new File("_java_io_\\a.txt")); // 重写 了 toString
        System.out.println(new File("G:\\study\\test")); // 重写 了 toString


        //把路径分为 两部分
        // 父路径和子路径
        //可以单独书写
        // 使用方便
        //父路径是file类型
        // 可以堆路径进行操作
        System.out.println(new File("G:\\study\\test", "demo1\\a.txt"));


        /// 常用方法
        /*
        * 获取
        *
        * getAbsolutePath // 绝对路径
        * getPath // 将file中的路径转为字符串 // 绝对 就是 绝对 ， 相对就是 相对
        * getName //filename
        * length // 文件大小
        *
        * toString调用了 getPath 方法
        *
        *
        * 判断
        *
        * exists // 存在
        *
        * isDirectory // 文件夹
        *
        * isFile // 文件
        *
        *
        * 创建 删除
        *
        * createNewFile // 创建
        *
        * delete // 删除
        *
        * mkdir // 创建目录
        *
        * mkdirs // 多级目录
        *
        *
        *
        * createNewFile // 返回布尔值
        * // 创建文件存在  // 不创建false
        * // 创建文件不存在 // 创建 true
        * // 不带后缀 就是一个 没后缀的文件喽
        * // 路径不存在 会抛出 IO异常
        *
        * */


        /*
        *  遍历目录
        *
        * list // 返回字符数组
        * listFiles // 返回 file数组
        *
        *
        * //遍历构造方法 给出的 路径
        *
        * //路径不存在 或者 不是 一个目录
        * // 会抛出 空指针 异常
        *
        *
        * 不过 并不会 区遍历 子目录里面的 内容
        * 隐藏文件 也会 打印
        *
        *
        * listFiles
        * //打印 会打印出 绝对路径
        *
        * */
        File file = new File("C:\\Users\\HJC\\IdeaProjects\\god-way\\src\\main\\java");
        Arrays.stream(Objects.requireNonNull(file.list())).forEach(System.out::println);


    }


    /**
     *
     * 递归打印多级目录
     *
     * // 并且判断文件类型
     * */
    static void m1(File file){
        Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach( r -> {
            if (r.isDirectory())
                m1(r);
            else{
                System.out.println(r.toString().toLowerCase().endsWith(".java") ? r.toString() : "");
            }
        });


        /*
        *
        * 文件过滤器
        *
        * listFiles的重载方法
        *
        * listFiles(FileFilter) //抽象路径名的过滤器 // 过滤文件
        *   参数 listFile 得到的文件对象
        * listFiles(FileNameFilter) //过滤文件名 // 过滤文件名
        *   参数 dir name // 传递的被遍历目录 和 遍历的每一个文件、文件夹 名称
        *
        *
        * 两个接口 需要重写
        * 没有实现类 需要自己重写
        * 自定义过滤规则
        *
        *
        *
        * */


    }



    /**
     * 自定义过滤器
     */
    class Demo1 implements FileFilter {

        @Override
        public boolean accept(File pathname) {
            //制定 过滤规则
            return false;
        }
    }
}
