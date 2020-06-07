package _a_java_model_.design._3_.struct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/7  21:47
 * @description :
 */
public class 装饰模式 {
    public static void main(String[] args) {
        HashMap map = new HashMap(){{
            this.put("B" , "1");
            this.put("C" , "2");
            this.put("A" , "3");
        }};

        HashSet set = new HashSet(map.keySet());
        set.forEach(System.out::println);
    }
}

abstract class Decorator{
    private C_A c_a;

    Decorator(C_A c_a) {
        this.c_a = c_a;
    }

    C_A getC_a() {
        return c_a;
    }

    abstract void show();
}
// 装饰器
class FlyDec extends Decorator{
    public FlyDec(C_A c_a) {
        super(c_a);
    }
    @Override
    void show() {
        this.getC_a().show();
        this.swim();
    }
    // 装饰
    void swim(){
        System.out.println("f");
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
