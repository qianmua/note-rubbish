package _java_model_._java_model_factory_.impl;

import _java_model_._java_model_factory_.afctory.Phone;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/13
 * @time 17:31
 */
public class Mi implements Phone {
    @Override
    public void start() {
        System.out.println("MI");
    }

    @Override
    public void down() {
        System.out.println("MI");

    }

    @Override
    public void call() {
        System.out.println("MI");

    }
}
