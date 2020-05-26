package _a_java_model_.design._3_.create;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/15
 * @time 22:13
 */
public class Factory {
    /*
    * 工厂模式
    * */


    // 简单 工厂

    public Pizz create(String type){
        Pizz pizz = null;

        if (type.equals("A")){

        }

        return pizz;
    }


}


interface Pizz{
    void name();
}

class APizz implements Pizz{
    @Override
    public void name() {
        System.out.println("A");
    }
}
class BPizz implements Pizz{
    @Override
    public void name() {
        System.out.println("AB");
    }
}
class CPizz implements Pizz{
    @Override
    public void name() {
        System.out.println("AC");
    }
}
class DPizz implements Pizz{
    @Override
    public void name() {
        System.out.println("AD");
    }
}
class EPizz implements Pizz{
    @Override
    public void name() {
        System.out.println("AE");
    }
}


class Order{

    /**
     * 传过来 一个
     * @param factory
     */
    public Order(Factory factory) {
        setFactory(factory);
    }

    Factory factory = null;

    Pizz pizz = null;

    public void setFactory(Factory factory) {
        // 你想 订购 的 类型
        String order = "";
        this.factory = factory;
        pizz = this.factory.create(order);

        if (pizz!= null){
            pizz.name();
        }

    }


}
