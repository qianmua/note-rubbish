package _a_juc_._四大函数式接口_;

import java.util.function.Function;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/27
 * @time 19:38
 */
public class DemoFunctionTest {


    public static void main(String[] args) {
        /*函数型接口*/
        //@FunctionalInterface
        System.out.println(new Function<String, String>() {

            @Override
            public String apply(String s) {
                return "sName? + " + s;
            }
        }.apply("hello"));

        Function<String,String> function = (str) -> str;
        System.out.println(function.apply("666"));

    }
}
