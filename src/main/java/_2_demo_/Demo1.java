package _2_demo_;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  13:40
 * @description :
 */
public class Demo1 {
    public static void main(String[] args) {
//        List<String> list = pickTwo("A", "B", "C");

        System.out.println("");

        System.out.printf(" dddd %d %n" , 3);
        System.out.printf(" dddd %d \n" , 4);
        System.out.println(5);
    }

    static <T> List<T> pickTwo(T a , T b , T c){
        switch (ThreadLocalRandom.current().nextInt(3)){
//            case 0 : return toArray();
//            case 1 : return toArray(a , c);
//            case 2 : return toArray(b , c);
        }
        throw new AssertionError();
    }

    static  <T> List<T> toArray(List<List<? extends T>> args){
        List<T> res = new ArrayList<>();
        for (List<? extends T> ts : args) {
            res.addAll(ts);
        }
        return res;
    }
}
