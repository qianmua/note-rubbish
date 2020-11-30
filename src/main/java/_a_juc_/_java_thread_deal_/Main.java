package _a_juc_._java_thread_deal_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/11
 * @time 21:14
 */
public class Main {
    public static void main(String[] args) {
        GetLock getLock1 = new GetLock(0,"老胡");
        GetLock getLock2 = new GetLock(1,"小胡");
        getLock1.start();
        getLock2.start();
    }
}

class Apple{}

class Origen{}

class GetLock extends Thread{

    private static final Apple apple = new Apple();
    private static final Origen origen = new Origen();

    private int what;
    private String name;
    public GetLock(int what , String name){
        this.what = what;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void get() throws InterruptedException {
        if (what == 0){
            synchronized (apple){
                System.out.println(this.name + "得到了" + apple.getClass().getName());
                Thread.sleep(1000);
                /**
                 *
                 * 死锁，卡死
                 * 拿到了对方的锁
                 */
                /*synchronized (origen){
                    System.out.println(this.name + "得到了" + origen.getClass().getName());
                }*/
            }
            synchronized (origen){
                System.out.println(this.name + "得到了" + origen.getClass().getName());
            }
        }else {
            synchronized (origen){
                System.out.println(this.name + "得到了" + origen.getClass().getName());
                Thread.sleep(2000);
                /*synchronized (this.apple){
                    System.out.println(name + "得到了" + origen.getClass().getName());
                }*/
            }
            synchronized (this.apple){
                System.out.println(name + "得到了" + apple.getClass().getName());
            }

        }
    }
}