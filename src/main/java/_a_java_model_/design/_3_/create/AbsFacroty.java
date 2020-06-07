package _a_java_model_.design._3_.create;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/7  15:04
 * @description :
 */
public class AbsFacroty {

    public static void main(String[] args) {
        F_Factory factory = new A_Factory();
        F_A a = factory.A();
        a.say();
        F_B b = factory.B();
        b.say();
    }

}


interface F{
    void say();
}

interface F_Factory{
    F_A A();
    F_B B();
}

class A_Factory implements F_Factory{

    @Override
    public F_A A() {
        return new F_A_A();
    }

    @Override
    public F_B B() {
        return new F_B_A();
    }
}
class B_Factory implements F_Factory{
    @Override
    public F_A A() {
        return new F_A_B();

    }
    @Override
    public F_B B() {

        return new F_B_B();
    }
}



abstract class F_A implements F{
    public abstract void say();
}

abstract class F_B implements F{
    public abstract void say();
}



class F_A_A extends F_A{

    @Override
    public void say() {
        System.out.println(this.getClass().getName());
    }
}
class F_A_B extends F_A{

    @Override
    public void say() {
        System.out.println(this.getClass().getName());
    }
}
class F_B_A extends F_B{

    @Override
    public void say() {
        System.out.println(this.getClass().getName());
    }
}
class F_B_B extends F_B{

    @Override
    public void say() {
        System.out.println(this.getClass().getName());
    }
}



