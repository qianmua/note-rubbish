package _2_demo_.bean_test.SpringBeanTest;

import org.springframework.stereotype.Component;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/3/13  9:31
 */
@Component
public class Bean {

    private static String demo1 = null;

    static {
        demo1 = "sad";
        System.out.println(demo1);
    }

    public String getDemo1() {
        return demo1;
    }
}
