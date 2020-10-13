package _2020_10_13_.basic;

public class StaticUtilityAppendent {

    public static void main(String[] args) {
        //静态内部类与外层类绑定，即使没有创建外层类的对象，它一样存在。
        StaticUtility.innerClass innerClass = new StaticUtility.innerClass();

        innerClass.method1();
        StaticUtility.innerClass.method2();
//        StaticUtility.innerClass.method3(); //报错
    }
}
