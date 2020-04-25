package _java_adapter_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/16
 * @time 13:12
 */
public class Adapter2 implements NetToUSB{
    private Adapte adapte;

    public Adapter2(Adapte adapte) {
        this.adapte = adapte;
    }

    @Override
    public void handler() {
        adapte.say();
    }

    /*适配器*/


}
