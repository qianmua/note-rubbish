package _java_model_factory_;

import _java_model_factory_.impl.Mi;
import _java_model_factory_.proFactoryAbstract.MiImpl;
import _java_model_factory_.proFactoryAbstract.ProFacA;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/13
 * @time 17:27
 */
public class Main {
    public static void main(String[] args) {
        MiImpl mi = new MiImpl();
        Mi mi1 = mi.MiPro();
        mi1.call();
        mi1.down();
        mi1.start();
    }
}
