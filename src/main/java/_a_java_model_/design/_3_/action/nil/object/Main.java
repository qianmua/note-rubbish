package _a_java_model_.design._3_.action.nil.object;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/16  14:07
 * @description :
 */
public class Main {


    /*
    空对象模式
     */
    public static void main(String[] args) {
        System.out.println(CustomerFactory.getCustomer("A").getName());
        System.out.println(CustomerFactory.getCustomer("B").getName());
        System.out.println(CustomerFactory.getCustomer("C").getName());
        System.out.println(CustomerFactory.getCustomer("E").getName());
    }
}
