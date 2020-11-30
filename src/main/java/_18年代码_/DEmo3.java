package _18年代码_;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/11/30  15:31
 * @description :
 */
public class DEmo3 {


    public static void main(String[] args) {

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("A");
            }
        } , 500 , 500);

        System.out.println("B");
    }
}

class D1 extends Thread{
    @Override
    public void run() {
        System.out.println("A");

    }
}
