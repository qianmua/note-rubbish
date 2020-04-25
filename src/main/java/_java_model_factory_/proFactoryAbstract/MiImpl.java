package _java_model_factory_.proFactoryAbstract;

import _java_model_factory_.impl.Mi;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/13
 * @time 17:36
 */
public class MiImpl implements ProFacA{
    @Override
    public Mi MiPro() {
        return new Mi();
    }
}
