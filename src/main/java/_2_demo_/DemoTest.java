package _2_demo_;

import lombok.Data;
import org.junit.Test;

import java.util.Random;

/**
 * description :
 *
 * @author mu.qian
 * @date 2021/1/18  21:41
 */
public class DemoTest {

    @Test public void demo_1(){
        int count = 0 , max = 0 , min = Integer.MAX_VALUE;
        int i = 100;
        while (i-- > 0){
            int tmp = new Random().nextInt(100);
            count = tmp > 50 ? ++count : count;
            max = Math.max(max, tmp);
            min = Math.min(min , tmp);
        }
        System.out.printf( " 大于50: %d , 最大值: %d , 最小值: %d %n" , count , max , min);

    }

    @Test public void demo_2(){
        // 指向的对象还是相同的
        // 映射的都似乎同一块内存地址
        _1 _1 = new dt1();
        _1.m1();
        _2 _2 = (dt1) _1;
        _2.m2();
        System.out.println(_2.equals(_1));
    }

    interface _1 { void m1(); }
    interface _2 { void m2(); }
    class dt1 implements _1 , _2{
        @Override
        public void m1() {
            System.out.println("m1");
        }

        @Override
        public void m2() {
            System.out.println("m2");
        }
    }


    @Test public void test_yinyong(){
        Stu stu = new Stu();
        stu.setName("A");

        // 引用对象?
        // 引用传递嘛？
        // 这里只是进行了值传递
        // 只是引用指针拷贝了，
        // 传递的值是指针指向的地址
        System.out.println(stu.getName());
        // 这里
        m1(stu);
        System.out.println(stu.getName());

    }
    private void m1(Stu stu){
        stu.setName("B");
    }

    @Data
    class Stu{
        private String name;
    }
}
