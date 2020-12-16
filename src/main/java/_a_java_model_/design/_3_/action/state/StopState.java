package _a_java_model_.design._3_.action.state;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/16  13:27
 * @description :
 */
public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("stop action");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "stop state";
    }
}
