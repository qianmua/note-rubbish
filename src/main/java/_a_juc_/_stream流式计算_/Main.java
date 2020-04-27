package _a_juc_._stream流式计算_;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/27
 * @time 19:57
 */
public class Main {

    /*
    * 计算交给流
    * */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.stream()
                .filter( i -> i % 2 == 0)
                .filter( i -> i % 5 != 0)
                .filter( i -> i % 6 != 0)
                .filter( i -> i % 7 != 0)
                .map( integer -> integer + 1)
                //排序  倒叙
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .forEach(System.out::println);
    }
}
