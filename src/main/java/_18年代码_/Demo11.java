package _18年代码_;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/28  15:10
 * @description : dfs 深度优先 bfs 广度优先
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

    @Test
    public void m11(){
        String s1 = new StringBuffer().append("aa").append("bb").toString();
        String s2 = new StringBuffer().append("ja").append("va").toString();
        //
        System.out.println(s1.intern() == s1);
        System.out.println(s2.intern() == s2);
    }
    
    @Test
    public void m12() throws JsonProcessingException {
        String jsonStr = "[1,2,3,4,5,6]";
        // jackson
        int[] ints = new ObjectMapper().readValue(jsonStr, int[].class);
        System.out.println(Arrays.toString(ints));

        // fastjson
        int[] ints1 = JSON.parseObject(jsonStr, int[].class);
        System.out.println(Arrays.toString(ints1));
    }

    static class ListNode implements Iterator<ListNode> {
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
        @Override
        public boolean hasNext() {
            return this.next != null;
        }

        @Override
        public ListNode next() {
            return this.next;
        }
    }

    ListNode node = new ListNode(0);
    @Before
    public void m13_bf(){
        ListNode root = this.node;
        for (int i = 1; i <= 10; i++) {
            if (this.node.next == null){
                this.node.next = new ListNode(i);
                this.node = this.node.next;
            }
        }
        this.node = root;
    }

    @Test
    public void m13(){
        if (node == null){
            return ;
        }
        ListNode head = this.node;

        for (int i = 0; i < 3; i++) {
            if (head.hasNext()){
                head = head.next;
            } // 临界点
        }
        while (head.hasNext()){
            this.node = this.node.next();
            head = head.next();
        }
        System.out.println(this.node.val);
    }


    @Test
    public void m14(){
        int a = a = 1;
        System.out.println(a);
    }
    class ObjectHeadTest{

    }
    class ObjectHeadTest2{
        int count = 100;
    }



}
