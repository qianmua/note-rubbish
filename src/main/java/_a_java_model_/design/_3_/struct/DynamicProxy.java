package _a_java_model_.design._3_.struct;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/8/4  22:34
 * @description : 动态代理
 */
public class DynamicProxy {

    public static void main(String[] args) {
        MyHandler handler = new MyHandler();
        SubRes instance = (SubRes) Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(), SubRes.class.getInterfaces(), handler);
        instance.say();
    }




    static class MyHandler implements InvocationHandler{

        private SubRes ob1;

        public void setOb1(SubRes ob1) {
            this.ob1 = ob1;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


            m1();
            Object invoke = method.invoke(this.ob1, args);
            m2();


            return invoke;
        }

        public void m1(){
            System.out.println("AAA");
        }

        public void m2(){
            System.out.println("BBB");
        }
    }


    interface Sub{
        void say();
    }

    static class SubRes implements Sub {

        @Override
        public void say() {
            System.out.println("A");
        }
    }
}
