package _a_java_model_.design._service_locator_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/24  11:09
 * @description :
 */
public class ServiceLocator {

    private static Cache cache;

    static {
        cache = new Cache();
    }

    public static Service getService(String jndiName){

        Service service = cache.getServices(jndiName);

        if (service != null){
            return service;
        }

        InitialContext context = new InitialContext();

        service = (Service) context.lookup(jndiName);
        cache.addService(service);

        return service;
    }
}
