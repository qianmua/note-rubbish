package _动态代理_._动态代理_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/26
 * @time 21:20
 */
public class F1 implements Usb {

    /**
    * 厂家
     *
     * 负责 买
     *
     * 销售的 去代理
     *
     * 我厂 只负责 我自己 的事情
    *
    * */
    @Override
    public long shell(int v1) {
        return v1 * 10;
    }

    @Override
    public long shell2(int v2) {
        return v2 * 100;
    }
}
