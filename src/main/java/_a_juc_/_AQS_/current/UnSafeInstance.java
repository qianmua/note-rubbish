package _a_juc_._AQS_.current;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/18  15:32
 * @description :
 */
public class UnSafeInstance {

    public static Unsafe refelectGetUnsafe(){
        try {
            Field unfases = Unsafe.class.getDeclaredField("theUnfase");
            unfases.setAccessible(true);
            return (Unsafe) unfases.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
