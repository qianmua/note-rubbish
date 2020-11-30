package _java_model_._java_model_strategy.sec;

import _java_model_._java_model_strategy.sec.impl.NoSay;
import _java_model_._java_model_strategy.sec.impl.YesFly;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/6
 * @time 13:04
 */
public class GreenDuck extends Duck {

    GreenDuck(){
        setFly(new YesFly());
        setSay(new NoSay());
    }
    @Override
    void dis() {
        System.out.println("6");
    }
}
