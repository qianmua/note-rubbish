package _java_jsonp_;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/13  22:56
 * @description :
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        //http://www.netbian.com/dongman/
        String url = "http://www.netbian.com/dongman/";
        //http://www.netbian.com/
        Document document = Jsoup.parse(new URL(url) , 3000);
        Elements list = document.getElementsByClass("list");
        //System.out.println(list);
        list.forEach(v1 -> {
            Elements ul = v1.getElementsByTag("ul");
            ul.forEach(v2 -> {
                Elements li = v2.getElementsByTag("a");
                li.forEach( v3 -> {
                    String href = v3.attr("href");
                    if (!href.startsWith("http")){
                        try {
                            Document parse = Jsoup.parse(new URL("http://www.netbian.com"+ href), 3000);
                            parse.getElementsByClass("pic")
                                    .forEach(v4 -> v4.getElementsByTag("img")
                                            .forEach(v5 -> {
                                                String src = v5.attr("src");
                                                try {
                                                    downImg(src);
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            }));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            });
        });


    }


    public static void downImg(String urlString) throws IOException {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5*1000);
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        File sf=new File("G:\\Java_Test\\img\\img1");
        if(!sf.exists()){
            sf.mkdirs();
        }
        // 扩展名
        String extensionName = urlString.substring(urlString.lastIndexOf(".") + 1);
        // 新的图片文件名 = 编号 +"."图片扩展名
        String newFileName = new Random().nextInt(100000) + "." + extensionName;
//        System.out.println();
        //urlString.substring(urlString.lastIndexOf("\\")+1)
        OutputStream os = new FileOutputStream(sf.getPath()+"\\"+newFileName);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }
}
