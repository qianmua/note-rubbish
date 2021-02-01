package _datasource_adapter_;

import org.junit.Test;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/2/2  0:50
 */
public class Main {


    @Test
    public void dynamic_proxy(){
        SI si = new I();

        Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class<?>[]{SI.class} ,
                (p , m , a) -> {
                    // hasCode
                    // equals
                    // toString
                    System.out.println(m.getName());
                    Object o = m.invoke(si);

                    return o;
                });
    }
}

/////////////////////////////////
interface SI {
    void sI();
}
class I implements SI{

    @Override
    public void sI() {
        System.out.println("A");
    }
}
/////////////////////////////////

abstract class MyDataSourceAdapter implements DataSource {

}
class MyDataSource {

    private static final List<Connection> POOL;
    static {
        POOL = new LinkedList<>();
        // Init
        POOL.add(null);

    }

}
