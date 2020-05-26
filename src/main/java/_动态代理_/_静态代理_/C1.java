package _动态代理_._静态代理_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/26
 * @time 21:21
 */
public class C1 implements Usb {

    // 声明 代理 的厂家


    /*
    * 我是 代理的
    *
    * 我只负责 把东西 卖出去
    *
    * 代理 了 厂家
    *
    * //this
    *
    * */

    private Usb f1 = new F1();

    @Override
    public long shell(int v1) {

        long shell = f1.shell(v1 + 1);
        System.out.println(" 给你 一个 优惠卷");
        return shell;
    }

    @Override
    public long shell2(int v2) {

        return f1.shell2(v2 + 20);
    }
}
