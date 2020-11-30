package _java_model_._java_model_single_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/10
 * @time 9:03
 */
public class SingleDemo3 {
    private volatile static SingleDemo3 signleDemo3;

    private SingleDemo3(){}

    /**
     * Double CheckLock实现单例：DCL也就是双重锁判断机制（由于JVM底层模型原因，偶尔会出问题，不建议使用）
     * @return
     */
    public static SingleDemo3 getSignleDemo3() {
        if (signleDemo3 == null){
            synchronized (SingleDemo3.class){
                if (signleDemo3 == null){
                    signleDemo3 = new SingleDemo3();
                }
            }
        }
        return signleDemo3;
    }
}
