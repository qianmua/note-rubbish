package _a_java_model_.design._business_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/23  10:16
 * @description : 业务代表。
 */
public class BusinessDelegate {

    private BusinessService businessService;

    private BusinessLookUp lookUp = new BusinessLookUp();

    private String serviceType;

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask(){
        businessService = lookUp.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}
