package _2020_10_13_.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 集合框架
 */
public class BasicCollection {
    public static void main(String[] args) {
        //Collections 是提供了对集合进行操作的强大方法的工具类 ，
        // 它包含有各种有关集合操作的静态多态方法。此类不能实例化（其构造函数是private的，该类中的方法都是static的可以直接调用）
        //参考Class08


        //Collections、Arrays：集合类的一个工具类/帮助类，其中提供了一系列静态方法，用于对集合中元素进行排序、搜索以及线程安全等各种操作。
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(0);
        list.add(3);
        list.add(7);
        list.add(4);
        Integer[] nums = new Integer[list.size()];
        list.toArray(nums);
        Arrays.sort(nums);
        for(Integer i:nums){
            System.out.println(i);
        }

    }
}
