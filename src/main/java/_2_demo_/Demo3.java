package _2_demo_;

import org.apache.commons.lang3.ThreadUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  15:18
 * @description :
 */
public class Demo3 {
    public static void main(String[] args) {
        lockList();
    }

    private static void lockList(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
                new Thread( () ->{
                    synchronized (list){
                        list.add(Thread.currentThread().getName());
                    }
                }).start();
        }


        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
