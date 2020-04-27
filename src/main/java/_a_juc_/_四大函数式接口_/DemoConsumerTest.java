package _a_juc_._四大函数式接口_;

import java.util.function.Consumer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/27
 * @time 19:49
 */
public class DemoConsumerTest {

    public static void main(String[] args) {
        /*
        * 消费性接口
        * 只有输入 没有返回；
        * */

        new Consumer<String>(){

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        }.accept("hello");

        Consumer<String> consumer = System.out::println;
        consumer.accept("hh");
    }
}
