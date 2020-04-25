package _java_proxy_handler_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/14
 * @time 22:40
 */
public class Main {

    public static void main(String[] args) {
        Host host = new Host();

        //代理角色
        ProxyInvocationHandler handler = new ProxyInvocationHandler();

        handler.setRent(host);

        Rent o = (Rent)handler.get();

        o.rens();

    }
}
