package _2020_10_13_.JUC;

import com.sun.corba.se.impl.orbutil.closure.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *Callable
 */
public class Class19 {


    public static void main(String[] args) {
        //FutureTask适配了Runnable和Callable接口
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        //线程只进行一次！
        new Thread(futureTask,"AA").start();
        new Thread(futureTask,"BB").start();
        try {
            //建议放在最后，因为这会阻塞直到计算完成
            System.out.println("result = " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
//泛型注入的是返回值
class MyThread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {//Callable有返回值
        System.out.println("进入Callable线程！！！！！！！！！！");
        return 10;
    }
}