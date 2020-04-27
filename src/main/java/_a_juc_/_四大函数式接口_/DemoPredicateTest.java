package _a_juc_._四大函数式接口_;

import java.util.function.Predicate;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/27
 * @time 19:45
 */
public class DemoPredicateTest {

    public static void main(String[] args) {
        /*
        * 断定型接口
        * */
        System.out.println(new Predicate<String>() {

            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        }.test("a"));

        Predicate<String> predicate = String::isEmpty;
        System.out.println( predicate.test("?"));
    }
}
