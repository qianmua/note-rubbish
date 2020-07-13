package _java_jsonp_;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
        Document document = Jsoup.parse(new URL(url) , 3000);
        Elements list = document.getElementsByClass("list");
        System.out.println(list);

    }
}
