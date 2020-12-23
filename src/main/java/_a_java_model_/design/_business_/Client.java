package _a_java_model_.design._business_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/23  10:18
 * @description : 客户端。
 */
public class Client {

    private BusinessDelegate businessDelegate;

    public Client(BusinessDelegate businessDelegate){
        this.businessDelegate = businessDelegate;
    }

    public void doTask(){
        businessDelegate.doTask();
    }


}
