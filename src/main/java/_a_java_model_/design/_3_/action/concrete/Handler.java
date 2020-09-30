package _a_java_model_.design._3_.action.concrete;


/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/30  19:30
 * @description : 责任链模式
 */
public abstract class Handler {

    protected Handler successor;

    public abstract void handleRequest();

    public Handler getSuccessor(){
        return this.successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

}
