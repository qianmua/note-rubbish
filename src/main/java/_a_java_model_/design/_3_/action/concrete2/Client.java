package _a_java_model_.design._3_.action.concrete2;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/30  19:41
 * @description :
 */
public class Client {

    public static void main(String[] args) {
        // 组装责任链

        DeptManager manager = new DeptManager();
        ProjectManager manager1 = new ProjectManager();
        GeneralManager manager2 = new GeneralManager();

        manager1.setSuccessor(manager);
        manager.setSuccessor(manager2);

        //test
        String a = manager1.handleFeeRequest("A", 100);
        String b = manager1.handleFeeRequest("A", 800);
        String c = manager1.handleFeeRequest("A", 2000);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}
