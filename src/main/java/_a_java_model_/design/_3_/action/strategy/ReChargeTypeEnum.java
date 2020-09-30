package _a_java_model_.design._3_.action.strategy;

import java.util.Objects;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/30  18:15
 * @description :
 */
public enum ReChargeTypeEnum {
    E_BANK(1),
    BUSI_ACCOUNTS(2),
    MOBILE(3),
    CARD_RECHARGE(4);

    private Integer value;

    public static ReChargeTypeEnum from(Integer type) {
        for (ReChargeTypeEnum value : ReChargeTypeEnum.values()) {

            if (Objects.equals(value.getValue(), type)){
                return value;
            }
        }

        return null;
    }

    ReChargeTypeEnum(Integer i) {
        this.value = i;
    }



    public Integer getValue() {
        return value;
    }
}
