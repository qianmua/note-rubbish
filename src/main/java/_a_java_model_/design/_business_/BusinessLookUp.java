package _a_java_model_.design._business_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/23  10:11
 * @description : 业务查询服务。
 */
public class BusinessLookUp {

    public BusinessService getBusinessService(String serviceType){

        return serviceType.equalsIgnoreCase("EJB") ?
               new EJBService() : new JMSService() ;
    }
}
