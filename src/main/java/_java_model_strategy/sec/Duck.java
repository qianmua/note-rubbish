package _java_model_strategy.sec;

import _java_model_strategy.sec.display.Fly;
import _java_model_strategy.sec.display.Say;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/5
 * @time 22:25
 */
public abstract class Duck {
    private Fly fly ;
    private Say say ;

    abstract void dis();

    void fly(){
        fly.fly();
    }

    public void setFly(Fly fly) {
        this.fly = fly;
    }

    public void setSay(Say say) {
        this.say = say;
    }

    void say(){
        say.say();
    }


}
