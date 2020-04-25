package _java_model_single_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/10
 * @time 9:07
 */
public class SingleDemo4 {
    private static class GetSigneleDemo4Class{
        private static SingleDemo4 signleDemo4 = new SingleDemo4();
    }

    private SingleDemo4(){}

    /**
     * 静态内部类实现模式（线程安全，调用效率高，可以延时加载）
     * @return single
     */
    public static SingleDemo4 getInstance(){
        return GetSigneleDemo4Class.signleDemo4;
    }

}
