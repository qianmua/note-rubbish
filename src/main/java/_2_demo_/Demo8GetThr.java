package _2_demo_;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/9  16:25
 * @description :
 */
public class Demo8GetThr {
    public static void main(String[] args) {
        getMe8();
    }

    static void getMe8(){

        String user = null;

        Optional.ofNullable(user).map((v) -> {
            System.out.println(v);
            return v;
        }).orElseThrow(() -> new RuntimeException("11111"));

    }

    @Test
    public void testOptional(){
        ArrayList<String> list = new ArrayList<String>() {{
            add("A");
            add("B");
        }};
//        list = null;

        Optional.ofNullable(list)
                .map(v-> {
                    if (!v.isEmpty()) {
                        v.forEach(System.out::println);
                    }
                    return new ArrayList<String>();
                })
//        ;
                .orElseGet(ArrayList::new);


    }
}
