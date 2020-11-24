package _18年代码_;

import java.util.HashMap;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/17  23:00
 * @description :
 */
public class Mark {

    //TODO 待做

    //FIXME 待修复

    //HACK 粗糙的解决方案

    //XXX 有问题


//    public static void main(String[] args) {
//        int main = main(new int[]{0, 1, 2, 45, 5, 4});
//        System.out.println(main);
//    }

    public static void main(String[] args) {
        // hashmap 扩容
        // size 属性 int类型
        // 添加值会自增
        // 要是 ++size > (负载因子 * 容器大小)
        // 扩容 原来的两倍

        // 最大扩容为：
        // Integer.MAX_VALUE
        /*HashMap<String, String> stringStringHashMap = new HashMap<>();
        String s = new String("111");
        int i = s.length();*/

        String str1 = "aabbccAABBCC";
        int i = str1.lastIndexOf(97); // a
        int i1 = str1.lastIndexOf("AB"); // string
        int i2 = str1.lastIndexOf('c' , 5); // char 起始搜索下标
        int i3 = str1.lastIndexOf("bb" , 2); // string 起始搜索下标

        System.out.println(i); //  1    最后一次出现的位置
        System.out.println(i1); // 7
        System.out.println(i2); // 5    结果与第二个参数有关系 理解起始搜索下标
        System.out.println(i3); // 2    结果与第二个参数有关系 理解起始搜索下标


        HashMap<String, String> map = new HashMap<>();


    }

//    public final static native int w();

    // strictfp
    strictfp interface Ains{
    }

    abstract class Abs{
//        abstract final double hype;
    }

}
