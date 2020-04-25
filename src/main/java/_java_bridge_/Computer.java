package _java_bridge_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/16
 * @time 12:55
 */
public abstract class Computer {

    protected Brand brand;

    public Computer(Brand brand){
        this.brand = brand;
    }

    public void info(){
        brand.say();
    }
}

class Desk extends Computer{

    public Desk(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("台式机");
    }
}
class Book extends Computer{

    public Book(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("笔记本");
    }
}