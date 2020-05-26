package _动态代理_._动态代理_;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/26
 * @time 22:24
 */
public class H1 implements InvocationHandler {


    ///传入 目标对象
    private Object proxy  = null;

    /**
     * 动态 传入 目标代理对象
     * @param proxy
     */
    public H1(Object proxy) {
        this.proxy = proxy;
    }

    /**
     * 动态 代理 必须 实现 这个
     *
     * 完成 你要做 的 功能
     *
     * 并且 执行 功能 增强
     *
     * invoke 和 Method 类中的 invoke 不同
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 执行 目标 方法
        Object invoke = method.invoke(this.proxy, args);

        if ( invoke != null ){
            long r = (long) invoke;
            r += 25L;
            invoke = r;
        }

        System.out.println("你买了 个东西 并且 送给你 一个 大嘴巴子");
        return invoke;
    }
}
