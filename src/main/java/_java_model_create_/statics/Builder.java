package _java_model_create_.statics;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/13
 * @time 20:10
 */
public abstract class Builder {
    abstract Builder builderA(String str);
    abstract Builder builderB(String str);
    abstract Builder builderC(String str);
    abstract Builder builderD(String str);

    abstract Product getProduct();

}
