package _java_proxy_handler_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/14
 * @time 22:41
 */
public class Host implements Rent{

    public void say(){
        System.out.println("买房子！");
    }

    @Override
    public void rens() {
        System.out.println("你要干什么啊！！！");
    }
}
