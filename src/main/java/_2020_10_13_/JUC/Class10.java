package _2020_10_13_.JUC;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋
 */
public class Class10 {
    AtomicReference<Thread> threadAtomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getId() + "   进入lock!");

        while(!threadAtomicReference.compareAndSet(null, thread)){

        }
    }

    public void myUnlock(){
        Thread thread = Thread.currentThread();
        threadAtomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getId() + "   出lock!");
    }

    public static void main(String[] args) {
        Class10 class10 = new Class10();
        for(int i=0; i<10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    class10.myLock();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    class10.myUnlock();
                }
            }).start();
        }
    }
}
