package _a_java_model_.design._3_.action.template;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/17  15:14
 * @description :
 */
public abstract class Game {

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    public final void play(){

        initialize();

        startPlay();

        endPlay();
    }
}
