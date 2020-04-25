package _java_juc_.demo.synlock;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/17
 * @time 20:16
 */
public class A {
    public static void main(String[] args) {
        Option option = new Option();
        new Thread( () ->{
            for (int i = 0; i < 10; i++) {
                try {
                    option.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread( () ->{

            for (int i = 0; i < 10; i++) {
                try {
                    option.del();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread( () ->{

            for (int i = 0; i < 10; i++) {
                try {
                    option.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread( () ->{

            for (int i = 0; i < 10; i++) {
                try {
                    option.del();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}

class Option{
    private int num = 0;

    public synchronized void add() throws InterruptedException {
        while (num != 0 ){
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "消费" + num);
        this.notifyAll();
    }

    public synchronized void del() throws InterruptedException {
        while (num == 0){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "消费" + num);
        this.notifyAll();
    }
}