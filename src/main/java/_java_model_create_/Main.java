package _java_model_create_;

import _java_model_create_.builder.Pro;
import _java_model_create_.factory.Work;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/13
 * @time 17:48
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        Pro pro = director.builder(new Work());
        System.out.println(pro.toString());
    }
}
