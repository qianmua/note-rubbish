package _java_single_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/14
 * @time 23:24
 */
public class LazyMain {
    private LazyMain(){

    }

    //原子性操作
    private volatile static LazyMain hungry;


    /**双重锁DCL*/
    public static LazyMain get(){
        if (hungry == null){
            synchronized (LazyMain.class){
                if (hungry == null){
                    //不是原子性操作
                    //指令重排？（有可能）
                    return new LazyMain();

                }
            }
        }
        return hungry;
    }

}
