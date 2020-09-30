package _a_java_model_.design._3_.action.strategy;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/30  18:20
 * @description :
 */
public class ZEBankStrategy implements Strategy {
    @Override
    public Double calAlg(Double d) {
        return 5.2 * d;
    }
}
