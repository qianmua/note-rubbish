package _a_java_model_.design._3_.action.observer;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/24  13:23
 * @description : 实体观察者
 */
public class BinaryObserver extends ObServer {

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("binary value :" + Integer.toBinaryString(subject.getState()));
    }
}
