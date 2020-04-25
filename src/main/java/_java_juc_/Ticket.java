package _java_juc_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/17
 * @time 19:54
 */
public class Ticket {
        private Integer count = 10;

        public synchronized void prov(){
            if (count > 0 ){
                System.out.println(Thread.currentThread().getName() + "操作时，值是" + count + " \t剩余" + count--);
            }
        }
}
