package _a_juc_._四大函数式接口_;

import java.util.function.Supplier;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/27
 * @time 19:52
 */
public class DemoSupplierTest {

    public static void main(String[] args) {
        /*供给型接口，只有然绘制，没有参数*/
        System.out.println(((Supplier) () -> "你好").get());

    }
}
