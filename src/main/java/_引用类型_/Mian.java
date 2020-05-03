package _引用类型_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/3
 * @time 12:06
 */
public class Mian {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.hashCode());
        System.out.println(a);
        f(a);
        System.out.println(a.a);
    }
    private static void f(A a){
        System.out.println(a.hashCode());
        System.out.println(a);
        a.a = 100;
    }

}
class A{
    int a;
}
