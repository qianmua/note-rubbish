package _2_demo_;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/3/22  19:44
 */
@Slf4j
public class SyncObjTest {

    public synchronized void mm1() {
        try {
            log.info("method mm1.");
            TimeUnit.SECONDS.sleep(10000);
            log.info("method mm1 ends.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void mm2(){
        log.info("method mm2.");
    }
}
