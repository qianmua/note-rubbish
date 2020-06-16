package _a_java_model_.design._3_.struct;

import java.util.HashMap;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/15  23:41
 * @description :
 */
public class Flyweight {

    /*
    *
    * 享元模式
    *
    * //
    * 与其他类似对象共享数据来减小内存占用
    *
    * */

    public static void main(String[] args) {

    }
}

abstract class Fly{
    abstract String color();

    public void dusplay(){
        System.out.println("a" + this.color());
    }
}


class Factory{
    private static Factory factory = new Factory();

    private static HashMap<String , Fly> pool;

    private Factory(){
        pool = new HashMap<>();
        Fly a , b;
        a = new A();
        pool.put("A",a);
        b = new B();
        pool.put("B",b);
    }


    public static Factory getFactory(){
        return factory;
    }

    public static Fly get(String name){
        return pool.get(name);
    }
}


class A extends Fly{

    @Override
    String color() {
        return "A";
    }
}

class B extends Fly{

    @Override
    String color() {
        return "B";
    }
}
