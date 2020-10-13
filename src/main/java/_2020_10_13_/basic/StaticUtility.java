package _2020_10_13_.basic;

/**
 * 关于static
 */
public class StaticUtility {
    //static修饰符表示静态的，在类加载时Jvm会把它放到方法区，被本类以及本类的所有实例所共用。
    // 在编译后所分配的内存会一直存在，
    // 直到程序退出内存才会释放这个空间。如果一个被所有实例共用的方法被申明为static，
    // 那么就可以节省空间，不用每个实例初始化的时候都被分配到内存。

    static public int a = 0;

    //如果static代码块有多个，JVM将按照它们在类中出现的先后顺序依次执行它们，每个代码块只会被执行一次。
    static{
        //在类被加载的时候用于初始化资源，仅能访问静态变量和静态方法
        System.out.println("First static block!");
    }

    static{
        //在类被加载的时候用于初始化资源，仅能访问静态变量和静态方法
        System.out.println("Second static block!");
    }

    static{
        //在类被加载的时候用于初始化资源，仅能访问静态变量和静态方法
        System.out.println("Third static block!");
    }

    public static void main(String[] args) {
        StaticUtility staticUtility1 = new StaticUtility();//静态块只会在类加载到内存中的时候执行一次
        StaticUtility staticUtility2 = new StaticUtility();

//        staticUtility1.a = 2; //不应该通过实体类访问static成员

//        innerClass.method1(); //报错!
        innerClass.method2();
        innerClass.method3();
    }

    //静态类：只能在内部类中定义静态类，静态内部类与外层类绑定，即使没有创建外层类的对象，它一样存在。
    static class innerClass{

        //静态类的方法可以是静态的方法也可以是非静态的方法，
        // 静态的方法可以在外层通过静态类调用，
        // 而非静态的方法必须要创建类的对象之后才能调用。

        public void method1(){
            System.out.println("unStatic method!");
        }

        public static void method2(){
            System.out.println("static method!");
        }

        private static void method3(){
            System.out.println("private static method!");
        }
    }
}
