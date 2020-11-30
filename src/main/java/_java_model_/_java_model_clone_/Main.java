package _java_model_._java_model_clone_;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/13
 * @time 20:50
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {


        Video v1 = new Video("哈哈",new Date());
        System.out.println(v1);

        Video v2 = (Video) v1.clone();
        System.out.println(v2);
        System.out.println(v1.hashCode());
        System.out.println(v2.hashCode());

        List<Integer> list  = new ArrayList<Integer>();
        list.add(1);
    }
}
