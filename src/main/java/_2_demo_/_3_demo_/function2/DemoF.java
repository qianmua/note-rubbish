package _2_demo_._3_demo_.function2;

import java.util.function.LongConsumer;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/5/24  15:58
 */
public interface DemoF {
    void m1();

    default void demofI(LongConsumer c , Long num){
        c.accept(num);
    }
}
