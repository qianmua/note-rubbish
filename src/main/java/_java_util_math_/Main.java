package _java_util_math_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/10
 * @time 11:48
 */
public class Main {
    public static void main(String[] args) {
        //因为在数轴上取值时，中间值（0.5）向右取整，所以正 0.5 是往上取整，负 0.5 是直接舍弃。同理,Math.round(1.5) = 2
        double a = Math.round(1.5);
        double a2 = Math.round(-1.5);
        double a3 = Math.round(-1.6);
        System.out.println(a);
        System.out.println(a2);
        System.out.println(a3);
    }
}
