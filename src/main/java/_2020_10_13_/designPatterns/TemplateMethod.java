package _2020_10_13_.designPatterns;

/**
 *模板方法模式
 * @author ACER
 */
public class TemplateMethod {
    public static void main(String[] args) {
        ConcreteComputer concreteComputer = new ConcreteComputer();
        concreteComputer.run();
    }
}


abstract class AbstractComputer{
    abstract void powerOn();
    abstract void runOs();
    abstract void playGame();
    abstract void powerOff();
    final void run(){
        powerOn();
        runOs();
        playGame();
        powerOff();
    }
}

class ConcreteComputer extends AbstractComputer{

    @Override
    void powerOn() {
        System.out.println("powerOn");
    }

    @Override
    void runOs() {
        System.out.println("runOs");
    }

    @Override
    void playGame() {
        System.out.println("playGame");
    }

    @Override
    void powerOff() {
        System.out.println("powerOff");
    }
}