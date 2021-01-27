package _2_demo_;

import org.junit.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/1/27  19:37
 */
public class RuntimeExecDocDemo {

    @Test
    public void testExec() throws Exception{

        Process exec = Runtime.getRuntime().exec("ping 8.8.8.8");
        InputStream is = exec.getInputStream();

        byte[] n = new byte[0];
        int t = 0;
        while ( ( t = is.read() ) != -1){
            System.out.print( ((char)t) );
        }
    }
}
