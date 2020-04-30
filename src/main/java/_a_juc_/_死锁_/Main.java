package _a_juc_._死锁_;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/28
 * @time 21:10
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        String la = "111";
        String lb = "222";

        Deal deal = new Deal(la,lb);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,2,3,TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );

        executor.execute(deal::getA);
        executor.execute(deal::getB);

//        TimeUnit.SECONDS.sleep(5);
        //别关线程池呐
//        executor.shutdown();

    }
}

class Deal{

    private String lA;
    private String lB;

    public Deal(String lA, String lB) {
        this.lA = lA;
        this.lB = lB;
    }

    public void getA(){
        synchronized (lA){
            System.out.println(Thread.currentThread().getName() + " get ->" + lA + " to - get ->" + lB);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lB){
                System.out.println(Thread.currentThread().getName() + " get ->" + lB + " to - get ->" + lA);
            }
        }
    }

    public void getB(){

    }
}
