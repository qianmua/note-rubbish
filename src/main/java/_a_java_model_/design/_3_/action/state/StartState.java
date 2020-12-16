package _a_java_model_.design._3_.action.state;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/16  12:44
 * @description :
 */
public class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println(" start action");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "start state";
    }
}
