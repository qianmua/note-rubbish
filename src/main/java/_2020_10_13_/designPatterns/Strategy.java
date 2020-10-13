package _2020_10_13_.designPatterns;

/**
 * 策略模式
 * @author ACER
 */
public class Strategy {
    CalculateStrategy calculateStrategy;

    public void setCalculateStrategy(CalculateStrategy calculateStrategy) {
        this.calculateStrategy = calculateStrategy;
    }

    public int getPrice(){
        return calculateStrategy.getPrice();
    }

    public static void main(String[] args) {
        Strategy strategy = new Strategy();
        strategy.setCalculateStrategy(new PlanePrice());
        System.out.println("飞机价格为：" + strategy.getPrice());

        System.out.println("-------------------------------------------");

        strategy.setCalculateStrategy(new TrainPrice());
        System.out.println("火车的价格为：" + strategy.getPrice());
    }
}

interface CalculateStrategy{
    int getPrice();
}

class PlanePrice implements CalculateStrategy{

    @Override
    public int getPrice() {
        return 1000;
    }
}

class TrainPrice implements CalculateStrategy{

    @Override
    public int getPrice() {
        return 500;
    }
}