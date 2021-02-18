package _18年代码_;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/28  15:10
 * @description :
 */
public class Demo11 {

    private final String addr;
    private final String tel;

    {
        addr = "12221";
        tel = "11110";

        System.out.println(addr);
        System.out.println(tel);

    }


    public static void main(String[] args) {
        int fee = 200;

        saveDef:save(fee); // 懵不？
        // 标签 :
        // 打一个标签......
    }

    static void saveDef(){}
    static void save(int fee){}


    // 序列化回调
    // readObject
    // writeObject


    // 动态编译
    // JavaFileObject


    // 常量注意 要全部编译
    // 注意常量 在编译期 就被定值
    // 而非是一个引用

    class D11_1{

    }

    class D11_2 extends D11_1{

    }

    class D11_2_1 extends D11_2 {}

    class D11_2_2 extends D11_1 {}

    class D11_3 {
        void m1(){
            D11_2 d112 = new D11_2();
            // 用于对象得判断
            // 基本类型不行
            if (d112 instanceof D11_1){

            }

            if (d112 instanceof D11_2_1){

            }

            D11_2_1 d1122 = new D11_2_1();
            /*if (d1122 instanceof D11_2_2){

            }*/


            // 直接返回false
            if (null instanceof Object){

            }


        }

    }


    @Test
    public void chu(){
        // -1
        System.out.println( -1 % 2 == 1);
        System.out.println( 2 % 2 == 1);
    }


    // 注意越界
    @Test
    public void yue(){
        final int MAX_VALUE = 2000;

        int cur = 100;

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
//        int input = 2147483647;

        if (input > 0 && input + cur < MAX_VALUE){
            System.out.println("SUCCESS: " + input);
        }

        System.out.println("Fail");


    }


    // 随机种子
    @Test
    public void seed(){
        int a = 2;
        a *= 2 + 3;
        System.out.println(a);
        Random random = new Random(1000);
        for (int i = 1; i < 4; i++) {
            // 1
            // -1244746321
            // 1060493871
            // -1826063944

            // 2
            // -1244746321
            // 1060493871
            // -1826063944

            // 执行随机数
            // 前三个一直固定
            // 同一台机器
            // 随机数被固定死了

            System.out.println(random.nextInt());
        }
    }

    //
    @Test
    public void interClass(){
        IA.ib.m1("name");
    }

    interface IA{
        IB ib = System.out::println;
    }
    interface IB{
        void m1(String name);
    }


    @Test
    public void m9(){
        int a = 3 * 2 / 3;
        System.out.println(a);
        a = 3 / 2 * 3;
        System.out.println(a);
    }

    @Test
    public void m10(){
        int a = 18 , b = 13;
        a += b;
        b = a - b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);
    }

}
