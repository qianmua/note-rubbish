package _2020_10_13_.designPatterns;

/**
 *建造者模式
 * @author ACER
 */
public class Builder {
    public static void main(String[] args) {
        AcerComputer acerComputer = new AcerComputer();
        acerComputer.setId(001).setPrice(5000).setName("Acer");
        System.out.println(acerComputer.toString());
    }
}

abstract class Computer{
    protected int id;
    protected int price;
    protected String name;

    public abstract Computer setId(int id);
    public abstract Computer setPrice(int price);
    public abstract Computer setName(String name);
}

class AcerComputer extends Computer{

    @Override
    public Computer setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public Computer setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public Computer setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "AcerComputer{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}