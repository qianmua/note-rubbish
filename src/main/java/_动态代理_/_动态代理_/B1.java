package _动态代理_._动态代理_;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/26
 * @time 22:32
 */
public class B1 {

    /*
    * 创建 代理对象 Proxy
    * */

    public static void main(String[] args) {

        // 目标对象
        Usb v1 = new F1();

        // 创建 invoke 对象
        // 代理 谁
        InvocationHandler h1 = new H1(v1);

        // 代理 对象
        // 得到 要代理 对象 的类加载器
        // 转成 接口对象
        Usb usb = (Usb) Proxy.newProxyInstance(v1.getClass().getClassLoader(), v1.getClass().getInterfaces(), h1);

        // 执行
        System.out.println(usb.shell(111));


    }
}
