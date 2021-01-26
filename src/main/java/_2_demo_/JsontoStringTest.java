package _2_demo_;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/1/25  18:03
 */
public class JsontoStringTest {

    @Test
    public void test2(){

        String s = JSON.toJSONString(true);
        System.out.println(s);
    }

    class DADD1{

    }
}
