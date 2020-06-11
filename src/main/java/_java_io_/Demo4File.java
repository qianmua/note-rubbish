package _java_io_;

import java.util.Properties;
import java.util.Set;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/11  16:46
 * @description :
 */
public class Demo4File {

    /*
    * properties
    * 属性集 继承自 hashtable
    *
    *
    * 可以使用
    * store 方法把集合熟保存到 硬盘中
    * load 把硬盘中保存数据《键值对》 读取到集合中
    *
    * 键值是字符串
    * // k v
    *
    * */

    /**
     * 存取数据
     */
    static void m1(){

        //set
        //get
        //stringProName //  返回键值 集
        Properties properties = new Properties();

        properties.setProperty("1" , "A");

        // 返回 set 集合
        Set<String> set = properties.stringPropertyNames();

        // store 方法
        // 参数
        // outputStream //字节流 不可以写中文
        // Writer // 可以写中文
        // comment // 描述信息 // 不饿可以中文哦

        // 会把 当前 属性集 中的 数据 写入到硬盘
        // 参数 规定 了 写入 的 类型
        // 描述

    }


    public static void main(String[] args) {

    }
}
