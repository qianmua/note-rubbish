package _java_model_._java_model_create_;

import _java_model_._java_model_create_.builder.Builder;
import _java_model_._java_model_create_.builder.Pro;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/13
 * @time 19:39
 */
public class Director {

    public Pro builder(Builder builder){
        builder.meB();
        builder.meC();
        builder.meA();
        builder.meD();
        return builder.getPro();

    }
}
