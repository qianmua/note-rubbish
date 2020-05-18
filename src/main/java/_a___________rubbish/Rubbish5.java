package _a___________rubbish;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/18
 * @time 22:47
 */
public class Rubbish5 {

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }


    class A{
        int a = 0;
    }

    class B extends A{
        void f(){
            int a = super.a;
        }
    }

}
