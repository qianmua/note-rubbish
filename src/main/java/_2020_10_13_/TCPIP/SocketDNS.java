package _2020_10_13_.TCPIP;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

public class SocketDNS {
    public static void main(String[] args) throws UnknownHostException, MalformedURLException {
//        InetAddress[] address = InetAddress.getAllByName("www.baidu.com");
//
//        System.out.println(address[0].getHostAddress());

        String url = "https://www.baidu.com";
        //String url = "https://www.baidu.com/baidu?tn=monline_3_dg&ie=utf-8&wd=%E9%95%BF%E6%B1%9F%E9%9B%A8%E8%AF%BE%E5%A0%82";
        URL urls = new URL(url);
        System.out.println(urls.getHost());
        System.out.println(urls.getPort());

        String hostAddress = InetAddress.getByName(urls.getHost()).getHostAddress();
        System.out.println(hostAddress);

    }
}
