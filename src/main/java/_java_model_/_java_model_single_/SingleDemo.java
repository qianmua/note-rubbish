package _java_model_._java_model_single_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/10
 * @time 8:52
 */
public class SingleDemo {
    /**
     * 饿汉式(线程安全，调用效率高，但是不能延时加载)：
     */
    private static SingleDemo modelTest = new SingleDemo();
    private SingleDemo(){}
    public static SingleDemo getModelTest(){
        return modelTest;
    }
}
