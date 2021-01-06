package _a_java_model_.design._3_.create.singleton;

import org.jetbrains.annotations.Contract;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/6  19:30
 * @description :
 */

public class Singleton {
    private static class SingletonHolder{
        public static final Singleton SINGLETON = new Singleton();
    }
    private Singleton(){}

    /*
    在声明为 final时 有个小知识：
     static 方法不能被 override 但是可以被 hide，子类中的 static 方法不是在 override 而是在隐藏，
     也就是说，如果在子类中直接调用该静态方法（不是通过类调用），那么调用的一定是子类自己的那个方法，而不是父类中的
     ，因为子类把父类那个隐藏起来了。而 final 会阻止隐藏，所以在子类中父类的 static 方法 被隐藏 就和 final 的 阻止隐藏 冲突了，
     因此编译就会报错。

    所以，本身在父类中声明为 static 的方法，在子类中确实不可以 override，并且子类会隐藏掉父类中的这个 static 方法，
    让自己的这个方法和父类的那个同名方法变成两个无关联的普通方法。
    如果在父类中的这个 static 方法加上了 final，那么子类中就不可以定义重名的方法了，因为子类的隐藏和 final 的阻止隐藏会发生冲突。
     */
    public static Singleton getInstance() {
        return SingletonHolder.SINGLETON;
    }
}
