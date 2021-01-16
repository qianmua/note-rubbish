package _java_ping_;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/1/16  13:20
 */
public class JavaPingTest {

    public static void main(String[] args) {

    }


    @Test public void jTest(){
        System.out.println(System.getProperty("sun.jnu.encoding"));

        String line = null;
        try ( BufferedReader br = new BufferedReader(
                new InputStreamReader(Runtime.getRuntime()
                        .exec("ping " + "192.168.92.1 -n 5")
                        .getInputStream(), "GBK"))){

            while ( (line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test public void sdk5Test(){
        try {
            InetAddress inetAddress = InetAddress.getByName("192.8.8.8");
            boolean b = inetAddress.isReachable(3000);
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
