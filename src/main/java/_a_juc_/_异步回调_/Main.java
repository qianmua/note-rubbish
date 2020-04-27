package _a_juc_._异步回调_;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/27
 * @time 21:46
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        * Future
        * */

        // Void 没有返回值
        CompletableFuture<Void> future = CompletableFuture.runAsync( () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("异步使用");
        });

        System.out.println("我先执行");

        //回调 ..会阻塞
        future.get();


        //有返回值
        // success fail
        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(() -> 1024);

        f.whenComplete( (a,b) -> {
            System.out.println("参数值 ->" +a);
            System.out.println("错误码 ->" +b);
        }).exceptionally( e -> -1).get();

    }
}
