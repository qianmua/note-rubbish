package _thread_java_test_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/9
 * @time 23:11
 */
public class Race {
    public static void main(String[] args) {
        Games games = new Games();
        new Thread(games,"乌龟").start();
        new Thread(games,"兔子").start();
    }
}

class Games implements Runnable{
    private boolean win = false;
    @Override
    public void run() {
        for (int i = 0; i <= 100 ; i++) {
            if (i >= 100 ){
                win = true;
                System.out.println("win is :" + Thread.currentThread().getName());
            }
            if (win){
                break;
            }
        }
    }
}
