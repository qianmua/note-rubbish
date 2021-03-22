package _2_demo_;

import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/3/22  19:44
 */
public class SyncObjTest {

    public synchronized void mm1() {
        try {
            TimeUnit.SECONDS.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void mm2(){
        System.out.println("111a");
    }
}
