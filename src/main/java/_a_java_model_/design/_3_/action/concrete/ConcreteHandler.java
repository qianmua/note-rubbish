package _a_java_model_.design._3_.action.concrete;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/30  19:32
 * @description :
 */
public class ConcreteHandler extends Handler {
    @Override
    public void handleRequest() {
        if (super.getSuccessor() != null){
            System.out.println("下一任");
            successor.getSuccessor().handleRequest();
        }else{
            System.out.println("处理");
        }

    }

}
