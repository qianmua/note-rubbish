package _es_._es6_;

import java.util.Scanner;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/12  20:05
 * @description :
 */
public class Init {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double m = 0;
        System.out.println("会员吗？ （true/false）");
        m = scanner.nextBoolean() ? m1(scanner , true) : m1(scanner , false);
        System.out.println(m);
    }
    static double m1(Scanner scanner , boolean status ){
        System.out.println("折扣 后的金额：");
        double v = scanner.nextDouble();
        return status ? v >= 1000 ? v * 0.75 : v * 0.8 : v * 0.9;
    }
}
