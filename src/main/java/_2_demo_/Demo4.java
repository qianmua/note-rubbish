package _2_demo_;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  15:47
 * @description :
 */
public class Demo4 {

    public static void main(String[] args) {
        // test
        int tests = 0;
        int passed = 0;
        Class<MyJunitTest> testClass = MyJunitTest.class;
        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)){
//                System.out.println("has annotation test");
            }
            tests++;
            try {
                method.invoke(null);
                passed++;
                System.out.println("pass");
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }catch (Exception e){
                System.out.println("invoke test...?");
            }
        }
    }


    // mark
    @Deprecated
    private interface DepA{}

    private class DA implements DepA{ }

    private class DB implements DepA{ }

    private class DC{
        void m1(){
            DepA da = new DA();
            DepA db = new DB();
        }
    }

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {}

class MyJunitTest {

    @Test
    public void m1(){
        System.out.println("m1");
    }
    @Test
    public static void m2(){
        System.out.println("m2");

    }

    public void m3(){
        System.out.println("m3");

    }

    public static void m4(){
        System.out.println("m4");

    }
}