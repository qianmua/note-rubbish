package _java_model_._java_model_strategy.first;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/5
 * @time 22:30
 */
public class Main {


    public static void main(String[] args) {
        Duck greenDuck = new GreenDuck();
        Duck redDuck = new RedDuck();

        greenDuck.display();
        greenDuck.say();
        greenDuck.sw();

        //要是扩展时有的类不需要呢? 就会溢出需求啦~
    }
}
