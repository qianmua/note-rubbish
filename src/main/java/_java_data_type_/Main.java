package _java_data_type_;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/9
 * @time 14:38
 */
public class Main {

    public static void main(String[] args) {

        int a = new Scanner(System.in).nextInt();
        for (int i = 0; i < a; i++) {
            for (int j = 1; j <a-i ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        /*while (true){
            Byte[] bytes = new Byte[1024 * 1024];
        }*/

        /*
        int i = 10;
        int i1 = 010;
        int i2 = 0x10;
        int i3 = 0b10010101;

        System.out.println("i = " + i);
        System.out.println("i1 = " + i1);
        System.out.println(i2);
        System.out.println(i3);

        float f = 1231232123123f;
        float f2 = f+1;
        System.out.println(f == f2);
        // 有限 离散 舍入误差 大约 接近不等于
        //true

        char c1  = 1;
        // 2 ^ 16 -1 ---> 65535
        System.out.println((int)Character.MAX_VALUE);
        System.out.println("\u0061");
*/

    }
}
