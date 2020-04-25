package _java_proxy_handler_;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/14
 * @time 22:42
 */

/**自动生成代理类*/
public class ProxyInvocationHandler implements InvocationHandler {

    /**被代理的接口
     * 动态代理
     * */
    Object rent;
    public void setRent(Object rent){
        this.rent = rent;
    }
    /**被代理的接口*/
    public Object get(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                rent.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(rent, args);
        after();
        return invoke;
    }

    private void before(){
        System.out.println("我是中介，下来是我代理的话");
    }

    private void after(){
        System.out.println("叛忍啊");
    }
}
