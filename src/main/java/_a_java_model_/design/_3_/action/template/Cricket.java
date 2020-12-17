package _a_java_model_.design._3_.action.template;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/17  15:15
 * @description :
 */
public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket game init");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket game start");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket  game end.");
    }
}
