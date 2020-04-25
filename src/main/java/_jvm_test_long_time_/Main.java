package _jvm_test_long_time_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/8
 * @time 23:39
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test1();
        test2();
        test3();
    }
    private static void test1(){
        User user = new User();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long end = System.currentTimeMillis();
        System.out.println(" : " + (end - start) + "/ms");
    }

    private static void test2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class userClass = user.getClass();
        Method getNames = userClass.getDeclaredMethod("getName", null);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getNames.invoke(user,null);
        }
        long end = System.currentTimeMillis();
        System.out.println(" : " + (end - start) + "/ms");
    }


    private static void test3() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class userClass = user.getClass();
        Method getNames = userClass.getDeclaredMethod("getName", null);
        getNames.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getNames.invoke(user,null);
        }
        long end = System.currentTimeMillis();
        System.out.println(" : " + (end - start) + "/ms");
    }
}
