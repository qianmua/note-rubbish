package _a_juc_._级联表达式_;

import java.util.function.Function;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/16
 * @time 12:13
 */
public class Main {

    /*级联表达式*/
    public static void main(String[] args) {
        //test
        // x -> x -> y + x;
        Function<Integer , Function<Integer , Integer>> function = x -> y -> x+y;

        System.out.println(function.apply(1).apply(2));

        /*
        * 柯里化函数
        * */
        /// 太tm烦了  这个



    }
}
