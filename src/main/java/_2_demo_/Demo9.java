package _2_demo_;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
    public void m3() throws InterruptedException, IOException {

        SyncObjTest test = new SyncObjTest();

        new Thread(test::mm1).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(test::mm2).start();

        System.in.read();
    }

    class M4 {
        @Setter
        @Getter
        private String names;
    }

    @Test
    public void m4(){
        M4 m4 = new M4();
        String s = null;
        m4.setNames(s);
        System.out.println(m4.getNames());
    }



    @Test
    public void m5(){
        List<String> list = null;
        list = new ArrayList<String>(){{
            add("A");
            add("B");
            add("C");
            add("D");
            add("E");
            add("F");
            add("G");
        }}.stream().filter(v -> v.equals("J")).collect(Collectors.toList());

        System.out.println(list);
    }

    @Test
    public void m6(){
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(null , "hello");

    }

    @Test
    public void m7(){
        int a = ra(), b = rb(); // init value 1

        if (++a == 1 && ++b ==1){ // exec ++a == 1 false && 短路 ++b没有执行
            doNothing(); // pass
        }
        System.err.printf("v1 : %d , v2 : %d \n" , a , b); // 2 , 1

        a = ra();
        b = rb(); // init value 1

        if (++a == 1 & ++b ==1){ // exec ++a == 1 false & ++ b == 1 false
            doNothing(); // pass
        }
        // 没有被短路
        System.err.printf("v1 : %d , v2 : %d \n" , a , b); // 2 , 2

        // | || 也是同理
        // 部分场景 这个挺有用的；

    }
    int ra(){
        return 1;
    }
    int rb(){
        return 1;
    }
    void doNothing(){ /* pass */}

    @Test
    public void m8(){
        System.err.println("1".equals(1));
        Object o = (Object) 1;
        if (o instanceof String) {

        }
    }


    @Test
    public void m9() throws IOException, InterruptedException {
        D9C d9C = new D9C();

        new Thread(d9C , "A").start();
        new Thread(d9C , "B").start();
        new Thread(d9C , "C").start();

        TimeUnit.SECONDS.sleep(2);
    }
}

class D9C implements Runnable{
    int m1 = 10;
    boolean b = true;
    @Override
    public void run() {
        while (b){
            bud();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private synchronized void bud(){
        if (m1 <= 0){
            b = false;
            return;
        }
        System.out.println(" :" + Thread.currentThread().getName() + " :\t\t" + m1--);
    }


}
