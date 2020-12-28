package _18年代码_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/11/30  16:14
 * @description :
 */
public class Demo4 {


    public static void main(String[] args) {
        final Integer i = new Integer(2000);
        final int i2 = 2000;

        final Integer i3 = 2000;


        final int i4 = 1;
        final Integer i5 = 1;
        final Integer i6 = 1;

        System.out.println(i == i2);
        System.out.println(i == i3);

        System.out.println(i4 == i5);
        System.out.println(i4 == i6);

    }
}
