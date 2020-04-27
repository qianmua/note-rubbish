package _a_juc_._集合安全_;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/26
 * @time 20:49
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
         /**
          *
          * Callable接口类似于Runnable ，因为它们都是为其实例可能由另一个线程执行的类设计的。
          * 然而，A Runnable不返回结果，也不能抛出被检查的异常。
          *
          *  Thread.start
          *
          * new Thread(new Runnable() {});
          * new Thread(new FutureTask<>());
          * new Thread(new FutureTask<>(CallAble));
          *
          * Callable无法直接启动的。
          * 但是：
          * FutureTask
          * FutureTask可用于包装Callable或Runnable对象。
          * 因为FutureTask实现Runnable ，一个FutureTask可以提交到一个Executor执行
          *
          * */

         //适配器
        FutureTask futureTask = new FutureTask(new C());
        new Thread(futureTask,"name").start();
        //结果会被缓存，提高效率
        new Thread(futureTask,"name").start();

        //可能产生阻塞，因为要等待执行
        Object o = futureTask.get();

    }
}

class C implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "?????";
    }
}
