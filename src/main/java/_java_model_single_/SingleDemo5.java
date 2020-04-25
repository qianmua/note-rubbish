package _java_model_single_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/10
 * @time 9:14
 */
public enum SingleDemo5 {
    /*enum*/
    INSTANCE;

    private SingleDemo5 () {
        //
    }
    /**属性*/
    private Object object = new Object();

    public Object getObject(){
        return object;
    }

    public Object InitService(){
        return new Object();
    }

}
