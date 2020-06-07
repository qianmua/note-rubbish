package _a_java_model_.design._3_.struct;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/7  21:47
 * @description :
 */
public class 装饰模式 {
    public static void main(String[] args) {

    }
}

interface C_A{
    void show();
}

class C_A_1 implements C_A{

    @Override
    public void show() {
        System.out.println("1");
    }
    void run(){
        System.out.println("1");
    }
}

class C_A_2 implements C_A{

    @Override
    public void show() {
        System.out.println("2");
    }
    void run(){
        System.out.println("2");
    }
    void fly(){
        System.out.println("2");
    }
}
