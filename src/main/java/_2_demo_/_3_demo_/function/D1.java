package _2_demo_._3_demo_.function;

import org.junit.Test;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/5/20  16:41
 */
public class D1 {


    @Test
    public void m1(){
        FunctionComs functionComs = new FunctionImpl();

        mm1();
        if (true){
            functionComs.retry( nothings -> mm1());
        }
    }

    void mm1(){
        System.out.println("helloworld");
    }
}
