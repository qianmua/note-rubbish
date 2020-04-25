package _java_single_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/14
 * @time 23:45
 */
/**静态内部类*/
public class Holder {
    private Holder(){}
    public Holder get(){
        return InnerClass.holder;
    }
    public static class InnerClass{
        private final static Holder holder= new Holder();
    }
}
