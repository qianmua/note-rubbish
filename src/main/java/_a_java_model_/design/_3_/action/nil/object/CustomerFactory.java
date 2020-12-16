package _a_java_model_.design._3_.action.nil.object;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/16  14:09
 * @description :
 */
public class CustomerFactory {

    public static final String[] names = {"A" , "B" , "C" , "D"};

    public static AbstractCustomer getCustomer(String name){
        for (String s : names) {
            if (s.equalsIgnoreCase(name))
                return new RealCustomer(name);
        }
        return new NullCustomer();
    }
}
