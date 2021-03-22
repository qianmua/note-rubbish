package _2_demo_;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/3/15  16:48
 */
public class Demo9 {

    @Test
    public void m1(){
        LocalDateTime time = LocalDateTime.now();

        LocalDateTime dateTime = LocalDateTime.now().minusMinutes(123);
        Duration between = Duration.between(time, dateTime);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println(between.toMinutes());
        LocalDateTime time1 = time.plusMinutes(between.toMinutes());
        System.out.println(time1);
    }

    @Test
    public void m2(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        HashSet<String> set = new HashSet<>(arrayList);
        Map<String, String> map = Maps.asMap(set, v -> v + "-");
        System.out.println(map);

    }


    @Test
    public void m3(){

        SyncObjTest test = new SyncObjTest();
        new Thread(test::mm2).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(test::mm1).start();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
