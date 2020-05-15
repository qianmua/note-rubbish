package _a_java_model_.design._3_.create;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/15
 * @time 21:57
 */
public class Singleton {

    /*
    * 单例
    * */

}

/**
 * 饿汉式
 */
class SingletonTest{

    private SingletonTest(){}

    private static final SingletonTest ins = new SingletonTest();

    public static SingletonTest getIns() {
        return ins;
    }
}

/**
 * 静态代码饿汉式
 */

class Sing2{
    private Sing2(){
        sing2 = new Sing2();
    }

    private static Sing2 sing2;

    public static Sing2 getSing2() {
        return sing2;
    }
}

/*
* 懒汉式
*
* 线程不安全
*
* synchronized 变为安全
*
* 性能问题
*
* DCL 双重检测
*
* volatile 保证原子性
* */

class Sing3{

    private Sing3(){}

    private static volatile Sing3 sing3;

    public static  Sing3 getSing3() {
        if (sing3 == null){
            synchronized(Sing3.class){
                if (sing3 != null) {
                    return new Sing3();
                }
            }
        }
        return sing3;
    }
}

/*
* 静态内部类
*
* 线程安全
* 外部类加载时内部类并不会
* */

class Sing4{
    private Sing4(){}

    private static class D{
        private static final Sing4 SING = new Sing4();
    }

    public static Sing4 getInstance() {
        return D.SING;
    }
}


/*
* 枚举
* */

enum Sing5{
    /**
     * test
     *
     * 属性
     */
    INS;


    public void say(){
        System.out.println("1");
    }
}


