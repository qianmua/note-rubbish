package _2020_10_13_.designPatterns;

/**
 *工厂方法模式
 * @author ACER
 */
public class Factory extends AbstractFactory{

    @Override
    public void concreateProduct() {
        System.out.println("进入工厂！！！");
        NewProduct product = new NewProduct();
        System.out.println("离开工厂！！！");
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.concreateProduct();
    }
}

abstract class AbstractFactory{
    public abstract void concreateProduct();
}

abstract class Product {
    public Product() {
    }
}

class NewProduct extends Product{
    public NewProduct() {
        System.out.println("生产产品！！！");
    }
}