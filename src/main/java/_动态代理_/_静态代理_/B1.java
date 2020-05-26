package _动态代理_._静态代理_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/26
 * @time 21:23
 */
public class B1 {

    /*
    * 静态代理  实现简单 容易 理解
    *
    *
    *
    *
    * 被代理类 是固定的
    *
    * 只能有几个固定的 厂家代理
    *
    * 不方便 代理扩展
    *
    *
    *
    *
    * */


    public static void main(String[] args) {
        C1 c1 = new C1();
        //  代理 了 增强了 功能
        System.out.println(c1.shell(1));
    }
}
