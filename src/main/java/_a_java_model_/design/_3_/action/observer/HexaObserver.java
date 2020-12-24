package _a_java_model_.design._3_.action.observer;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/24  13:35
 * @description :
 */
public class HexaObserver extends ObServer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex Integer : " + Integer.toHexString(subject.getState()));
    }
}
