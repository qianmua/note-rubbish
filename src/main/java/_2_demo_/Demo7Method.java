package _2_demo_;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  18:40
 * @description :
 */
public class Demo7Method {


    public static void main(String[] args) {
        listRemove();
    }

    static void listRemove(){
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
            // list remove 有俩重载
            list.remove((Integer) i);
        }

        System.out.println(set);
        System.out.println(list);

    }

}
