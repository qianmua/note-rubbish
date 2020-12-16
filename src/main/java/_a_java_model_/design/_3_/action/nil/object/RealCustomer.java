package _a_java_model_.design._3_.action.nil.object;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/16  14:06
 * @description :
 */
public class RealCustomer extends AbstractCustomer{

        public RealCustomer(String name){
            this.name = name;
        }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
