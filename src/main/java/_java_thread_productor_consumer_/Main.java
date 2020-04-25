package _java_thread_productor_consumer_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/11
 * @time 22:21
 */

/**
 * 管程法
 */
public class Main {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}
//生产者
class Productor extends Thread{
    private SynContainer container;

    public Productor(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            container.push(new Chicken(i));
            System.out.println("生产鸡编号是：" + i);
        }
    }
}

//消费者
class Consumer extends Thread{
    private SynContainer container;

    public Consumer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("消费鸡编号是：" + container.pop().id);
        }
    }
}

//产品
class Chicken{
    int id ;
    public Chicken(int id){
        this.id = id;
    }
}

/**缓冲区*/
class SynContainer{
    /**容器大小*/
    private Chicken[] chickens = new Chicken[10];
    /**计数器*/
    private int count = 0;

    /**push*/
    public synchronized void push(Chicken chicken){
        if (count == chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count++] = chicken;
        this.notifyAll();
    }

    /**pop*/
    public synchronized Chicken pop(){
        if (count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}