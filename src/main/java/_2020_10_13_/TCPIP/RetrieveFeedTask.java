package _2020_10_13_.TCPIP;

import sun.rmi.runtime.Log;

import java.io.IOException;
import java.net.*;

public class RetrieveFeedTask {

    public static void main(String[] args) {


        String[] urls = new String[]{"https://www.baidu.com:443/","https://www.qq.com:443/"};

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Socket socket = new Socket();
                        String net = "NO_CONNECTION";
                        String host = "";
                        String ip = "";
                        int dns = Integer.MAX_VALUE;
                        int cnt = Integer.MAX_VALUE;
                        boolean isSuccessful = false;

                        URL url = new URL(urls[1]);
                        System.out.println("url为："+url);

                        String hostAddress;
                        long start = System.currentTimeMillis();
                        //url.getHost():
                        //String url = "https://www.baidu.com";
                        //URL urls = new URL(url);
                        //System.out.println(urls.getHost());
                        //返回：www.baidu.com
                        //但是如果String url = "www.baidu.com";
                        //抛出异常：Exception in thread "main" java.net.MalformedURLException: no protocol: www.baidu.com
                        //String hostAddress = InetAddress.getByName(urls.getHost()).getHostAddress();
                        //返回182.61.200.6
                        hostAddress = InetAddress.getByName(url.getHost()).getHostAddress();
                        long dnsResolved = System.currentTimeMillis();//获取当前时间，以ms来计
                        //System.out.println(urls.getPort());
                        //返回-1
                        // InetAddress:主要作用是封装IP及DNS
                        //InetSocketAddress：主要作用是封装端口 他是在在InetAddress基础上加端口
                        SocketAddress socketAddress = new InetSocketAddress(hostAddress, url.getPort());
                        socket.connect(socketAddress, 200);//0.2 毫秒的超时连接，如果没有连接上说明失败了
                        socket.close();
                        long probeFinish = System.currentTimeMillis();
                        dns = (int) (dnsResolved - start);
                        cnt = (int) (probeFinish - dnsResolved);
                        host = url.getHost();
                        ip = hostAddress;

                        System.out.println("ping成功！！！！");
                        Thread.sleep(500);

                    } catch (Exception ex) {
                        System.out.println("抛出异常");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } finally {

                    }
                }
            }
        }).start();
    }
}
