package _a_jvm_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/6
 * @time 10:49
 */

/**
 *
 * 早期绑定，晚期绑定
 *
 * 方法的调用
 *
 * 虚方法，非虚方法
 *
 * 静态方法，私有，final，实例构造器，父类方法都是非虚方法
 *
 * 补充： 多态的前提： 继承关系，重写方法
 *
 * 四个普通调用指令
 * invokestatic， 非虚方法
 * invokespecial，非虚方法
 * virtual，
 * interfacek
 *
 * 动态调用指令
 * dynamic （j7） 比如 lambda
 *
 *
 * 方法返回地址：
 *
 * 存放调用该方法的pc寄存器的值
 *
 *
 *
 * */
class Banding {

    void eat(){
        System.out.println("eating...");
    }
}

interface Hunt{
    void hunt();
}

class Dog extends Banding implements Hunt{
    @Override
    void eat() {
        //早期绑定
        super.eat();


        System.out.println("eat shi..");
    }

    @Override
    public void hunt() {
        System.out.println("sb");
    }
}

class Cat extends Banding implements Hunt{
    @Override
    void eat() {
        System.out.println("eat mouse");
    }

    @Override
    public void hunt() {
        System.out.println("gun");
    }
}

//晚期绑定
/**
 * 编译器不能确定下来调用的是谁
 *
 * */
public class BandingTest{

    void showB(Banding banding){
        banding.eat();
    }

    void showH( Hunt hunt){
        hunt.hunt();
    }

}