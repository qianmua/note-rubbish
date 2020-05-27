package _算法与数据结构_._线性表_;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/27  15:25
 * @description :
 */
public class Demo1 {


    // 有效 字母 异位词

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String v1 = scanner.next();
        String v2 = scanner.next();
        HashSet arr = new HashSet();

        char[] chars = v1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            arr.add((int) chars[i]);
        }
        chars = v2.toCharArray();
        int count = arr.size();
        for (int i = 0; i < chars.length; i++) {
            arr.add( (int) chars[i]);
        }
        System.out.println( count == arr.size());
    }
}
