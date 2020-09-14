package _java8_;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/14  16:40
 * @description :
 */
public class Stream1 {

    @Test
    public void m1(){
        HashMap<Boolean, Consumer> map = new HashMap<>();
        List<Integer> list = Arrays.asList(1, 23, 4, 5, 6, 7, 8, 9);

        Consumer aTrue = v -> System.out.println("true");
        Consumer aFalse = v -> System.out.println("false");

        list.forEach(v1 -> {
            map.put(true , aTrue);
            map.put(false, aFalse);

            map.get( v1.intValue() %2 == 0).accept(v1);
        });



    }
}
