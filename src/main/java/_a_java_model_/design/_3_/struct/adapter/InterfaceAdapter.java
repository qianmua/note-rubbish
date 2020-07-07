package _a_java_model_.design._3_.struct.adapter;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/7  22:21
 * @description :
 */
public class InterfaceAdapter  {

    /**
     * 接口 适配器
     *
     * 有选择 行的 实现
     *
     * WebBvcConfigure
     * @param args
     */
    public static void main(String[] args) {

    }

    interface AdapterDefault{
        default void m1(){}
        default void m2(){}
        default void m3(){}
    }

    class Client implements AdapterDefault{
        @Override
        public void m1() {
            System.out.println(" 适配 m1");
        }
    }
}
