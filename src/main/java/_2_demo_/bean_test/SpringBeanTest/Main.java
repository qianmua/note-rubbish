package _2_demo_.bean_test.SpringBeanTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/3/13  9:28
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext cc = new AnnotationConfigApplicationContext(App.class);
        Bean bean = cc.getBean("bean", Bean.class);
        StaticBean bean1 = new StaticBean();
        System.out.println(bean.getDemo1());
    }
}
