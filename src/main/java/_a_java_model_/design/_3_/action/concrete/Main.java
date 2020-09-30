package _a_java_model_.design._3_.action.concrete;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/30  19:33
 * @description :
 */
public class Main {
    public static void main(String[] args) {
        ConcreteHandler handler = new ConcreteHandler();
        ConcreteHandler handler1 = new ConcreteHandler();
        handler.setSuccessor(handler1);
        handler1.handleRequest();
    }


}
