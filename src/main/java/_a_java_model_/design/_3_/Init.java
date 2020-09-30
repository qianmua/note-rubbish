package _a_java_model_.design._3_;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/15
 * @time 21:57
 */
public class Init {
    public static void main(String[] args) {

        System.out.println("A".hashCode());
        System.out.println("B".hashCode());
        System.out.println("C".hashCode());
        //
        System.out.println("///==========//");
        HashMap<Double ,String> map = new HashMap<Double , String>(){{
            put(10.1 ,"A");
            put(10.2 ,"B");
            put(10.3 ,"C");
            put(10.4 ,"C");
        }};

        HashSet<Object> set = new HashSet<>();
        set.add(null);

        map.forEach( (k ,v) -> System.out.println(k.hashCode() + " " + k));
        System.out.println("///==========//");




    }
}
