package _java_model_._java_model_single_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/10
 * @time 8:58
 */
public class SingleDemo2 {
    private static SingleDemo2 signleDemo2;
    private SingleDemo2(){}

    /**
     *  懒汉式 ：线程安全，调用效率不高，但是能延时加载
     * @return
     */
    synchronized public static SingleDemo2 getSignleDemo2(){

        return signleDemo2 == null ? new SingleDemo2() : signleDemo2;

    }
}
