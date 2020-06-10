package _git_;

import java.math.BigDecimal;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/10  17:36
 * @description :
 */
public class Init {

    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal("10.1");

        MyCircle circle = new MyCircle(1.0);
        MyCircle circle2 = new MyCircle(2.0);
        MyCircle circle3 = new MyCircle(1.0);
        System.out.println(circle.equals(circle2));
        System.out.println(circle.equals(circle3));
        System.out.println(circle.equals(new Object()));

    }


    static class MyCircle{
        private double r;
        MyCircle(double r) {
            this.r = r;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof MyCircle)
                return this.r == ((MyCircle) obj).r;
            return false;
        }
    }
}
