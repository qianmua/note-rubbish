package _2_demo_._3_demo_.function;

import java.util.function.Consumer;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/5/20  10:19
 */
@FunctionalInterface
public interface FunctionComs {

    void m1(Consumer<String> consumer);


    default void retry(Consumer consumer){
        consumer.accept(null);
    }

}
