package _java8_;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/23  10:18
 * @description :
 */
public class Init {

    public static void main(String[] args) {
        System.out.println("add(1,2) = " + add(1, 2));
    }

    public static int add(int a, int b){
        if (b == 0){
            return a;
        }
        int sum = a ^ b;
        int c = (a&b) << 1;
        return add(sum , c);
    }

    public static int subt(int a, int b){
        return add(a , add(~b , 1 ));
    }


}
