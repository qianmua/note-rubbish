package _动态代理_._反射_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/26
 * @time 21:52
 */
public class Mian {


    /*
    * java 反射
    *
    * */

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
         A b = new B();
         b.say("666");

         /*
         *  通过 反射 机制 执行 say
         * */

         //后面跟的方法参数
        Method say = b.getClass().getMethod("say" , String.class);
        // 执行
        //
        say.invoke(b , "66");
    }
}
