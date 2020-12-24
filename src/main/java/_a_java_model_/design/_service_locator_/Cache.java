package _a_java_model_.design._service_locator_;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/24  10:59
 * @description :
 */
public class Cache {

    private List<Service> services;

    public Cache(){
        services = new ArrayList<>();
    }

    public Service getServices(String serviceName) {
        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(serviceName)){
                System.out.println("returning cached " + serviceName);
                return service;
            }
        }
        return null ;
    }

    public void addService(Service newService){
        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(newService.getName()))
                return;
        }
        services.add(newService);
    }
}
