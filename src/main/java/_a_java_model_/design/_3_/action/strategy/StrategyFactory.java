package _a_java_model_.design._3_.action.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/30  18:13
 * @description :
 */
public class StrategyFactory {
    public static StrategyFactory strategyFactory = new StrategyFactory();

    private static Map<ReChargeTypeEnum , Strategy> map = new HashMap<>();

    static {
        map.put(ReChargeTypeEnum.E_BANK , new ZEBankStrategy());
        map.put(ReChargeTypeEnum.BUSI_ACCOUNTS , new ZBusiAcctStrategy());
        map.put(ReChargeTypeEnum.MOBILE , new ZMobileStrategy());
        map.put(ReChargeTypeEnum.CARD_RECHARGE , new ZCardStrategy());
    }

    public static StrategyFactory getInstance(){
        return strategyFactory;
    }

    public Strategy creator(ReChargeTypeEnum type){
        return map.get(type);
    }
}
