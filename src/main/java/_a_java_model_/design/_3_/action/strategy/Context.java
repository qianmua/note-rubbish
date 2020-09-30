package _a_java_model_.design._3_.action.strategy;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/30  18:01
 * @description :
 */
public class Context {

    private Strategy strategy;

    public Double call(Double d , Integer type){
        // factory gen 策略
        strategy = StrategyFactory.getInstance().creator(ReChargeTypeEnum.from(type));

        if (strategy == null){
            throw new RuntimeException("策略异常");
        }
        return strategy.calAlg(d);
    }
}
