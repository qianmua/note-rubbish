package _2020_10_13_.jvm;

import java.util.Collection;

/**
 * 测试java的类加载机制
 */
public class JVMClassLoaderTest extends Father {
    {
        System.out.println("JVMClassLoaderTest的第一块构造代码块！");
    }

    public JVMClassLoaderTest() {
        System.out.println("JVMClassLoaderTest的构造方法！");
    }

    {
        System.out.println("JVMClassLoaderTest的第二块构造代码块！");
    }

    static {
        System.out.println("JVMClassLoaderTest的静态构造代码块！");
    }


    public static void getFather(){
        System.out.println("JVMClassLoaderTest!!!!!!!!!！");
    }

    public static void main(String[] args) {
        System.out.println("----------------------进入JVMClassLoaderTest的main方法！--------------------");

        JVMClassLoaderTest jvmClassLoaderTest = new JVMClassLoaderTest();

        JVMClassLoaderTest jvmClassLoaderTest1 = new JVMClassLoaderTest();

        Father father = new Father();

        Father father1 = new Father();

        getFather();

    }
}

/**
 * 父类
 */
 class Father{
    {
        System.out.println("父类的第一块构造代码块！");
    }

    public Father() {
        System.out.println("父类的构造方法！");
    }

    {
        System.out.println("父类的第二块构造代码块！");
    }

    static {
        System.out.println("父类的静态构造代码块！");
    }

    public static void getFather(){
        System.out.println("父类!!!!!!!!!！");
    }
}
