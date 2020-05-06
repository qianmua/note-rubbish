package _java_model_strategy.sec.impl;

import _java_model_strategy.sec.display.Say;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/6
 * @time 12:56
 */
public class YesSay implements Say {

    @Override
    public void say() {
        System.out.println(" yes say");
    }
}
