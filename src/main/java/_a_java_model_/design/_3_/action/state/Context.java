package _a_java_model_.design._3_.action.state;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/16  12:43
 * @description :
 */
public class Context {

    public State state;

    public Context(){
        state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
