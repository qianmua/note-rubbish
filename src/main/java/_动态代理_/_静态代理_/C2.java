package _动态代理_._静态代理_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/26
 * @time 21:29
 */
public class C2 implements Usb {

    /**
     * 第二家 代理
     *
     *
     */
    private F1 f1 = new F1();
    @Override
    public long shell(int v1) {
        System.out.println("送红包");
        return f1.shell(v1 + 1);
    }

    @Override
    public long shell2(int v2) {
        return 0;
    }
}
