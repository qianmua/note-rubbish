package _2_demo_.bean_test.SpringBeanTest;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/3/13  9:37
 */
public class StaticBean {
    private static String s1 = null;

    static {
        s1 = "dads";
    }

    public static String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        StaticBean.s1 = s1;
    }
}
