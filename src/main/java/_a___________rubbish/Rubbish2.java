package _a___________rubbish;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/3
 * @time 17:51
 */
public class Rubbish2 {


    /**
     * 一个小学生的沙比问题
     * */
    public static void main(String[] args) {

        Pop pop = new Pop();
        for (int i = 0; i < 10; i++) {
            final int j = i;
            new Thread( ()->{
                pop.name = ""+ j;
                /*try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println(Thread.currentThread().getName() + " ->" + pop.name);
            },String.valueOf(j)).start();
        }
    }

}
class Pop{
    String name;
}
