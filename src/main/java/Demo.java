/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/22
 * @time 14:46
 */
public class Demo {
    public static void main(String[] args) {
         A a = new B();
         a.say();
    }
}

class A{
    public void say(){
        System.out.println("A");
    }
}

class B extends A{
    @Override
    public void say() {
        super.say();
        System.out.println("B");
    }
}
