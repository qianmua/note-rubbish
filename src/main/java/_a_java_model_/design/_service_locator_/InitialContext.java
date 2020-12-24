package _a_java_model_.design._service_locator_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/24  10:52
 * @description :
 */
public class InitialContext {

    public Object lookup(String jndiName){
        if (jndiName.equalsIgnoreCase("SERVICE1")){
            System.out.println("init service1");
            return new Service1();
        }
        if (jndiName.equalsIgnoreCase("SERVICE2")){
            System.out.println("init service2");
            return new Service2();
        }

        return null;
    }
}
