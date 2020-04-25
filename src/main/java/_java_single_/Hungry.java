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
public class Hungry {
    private Hungry(){

    }

    private final static Hungry hungry = new Hungry();


    public static Hungry get(){
        return hungry;
    }

}
