package _java_model_strategy.sec;

import _java_model_strategy.sec.impl.NoFly;
import _java_model_strategy.sec.impl.YesSay;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/6
 * @time 13:05
 */
public class RedDuck extends Duck {

    RedDuck(){
        setFly(new NoFly());
        setSay(new YesSay());
    }

    @Override
    void dis() {
        System.out.println("7");
    }
}
