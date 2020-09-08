package _java_jsonp_;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/13  22:56
 * @description : 爬取图片
 */
public class Demo {

    public static void main(String[] args) {
        // http://www.netbian.com/youxi/index_2.htm // max 75
        //http://www.netbian.com/dongman/index_2.htm // max 142
//        initJsoupAndGetUrl("youxi",1);
        initJsoupAndGetUrl("dongman",1);
    }

    /**
     * 初始化
     * @param pathName 网页路径
     * @param maxPage 最大页数
     */
    private static void initJsoupAndGetUrl(String pathName, int maxPage)  {
        // 开线程池去 爬
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,
                50,
                3,
                TimeUnit.SECONDS ,
                new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try {
            // min
            if( maxPage <= 1){
                toJsoup(pathName, 0);
            }else {
                for (int i = 1; i <= maxPage; i++) {
                    int finalI = i;
                    executor.execute( () -> {
                        try {
                            toJsoup(pathName, finalI);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }

    /**
     * 解析 dom
     * @param pathName 路径
     * @param index 页码
     * @throws IOException
     */
    private static void toJsoup(String pathName ,int index) throws IOException {
        //http://www.netbian.com/dongman/
        // 地址
        // index_2.htm
        // index_1
        // index_2
        // index_3 ....
//        String url = ;
        String url = index > 0 ?
                "http://www.netbian.com/" + pathName +"/index_"+ index +".htm"
                : "http://www.netbian.com/" + pathName +"/index.htm";

//        StringBuilder url = new StringBuilder();
//        url.append( index > 0 ?
//                "http://www.netbian.com/" + pathName +"/index_"+ index +".htm"
//                : "http://www.netbian.com/" + pathName +"/index"+ index +".htm" );

        // 磁盘 路径
        // 路径下必须要有 文件夹
        // 不玩会报NPE
        String path = "G:\\Java_Test\\img\\img1";
        //http://www.netbian.com/
        // 得到 document 对象
        Document document = Jsoup.parse(new URL(url) , 3000);
        // 选择 标签 -> 分析 网页 得到
        Elements list = document.getElementsByClass("list");
        GetUrl(path, list);
    }

    /**
     * 解析 图片 地址
     * @param path 路径
     * @param list dom 表
     */
    private static void GetUrl(String path, Elements list) {
        //System.out.println(list);
        // each -> data
        // 致命 嵌套 //
        // 下次 优化
        // 睡觉了
        list.forEach(v1 -> {
            // 得到 标签集
            Elements ul = v1.getElementsByTag("ul");
            // each'
            ul.forEach(v2 -> {
                // 得到 标签集
                Elements li = v2.getElementsByTag("a");
                // each'
                li.forEach( v3 -> {
                    // 目标图片 地址
                    // 接续到 是一个 网页
                    // 继续深度 jsoup
                    // 重复 操作
                    String href = v3.attr("href");
                    if (!href.startsWith("http")){
                        // IO 异常 需要在lambda里面处理
                        // 闭包
                        try {
                            // 拼接 url
                            // 重复 解析
                            Document parse = Jsoup.parse(new URL("http://www.netbian.com"+ href), 3000);
                            //得到标签解析
                            parse.getElementsByClass("pic")
                                    // 死亡 嵌套
                                    .forEach(v4 -> v4.getElementsByTag("img")
                                            .forEach(v5 -> {
                                                String src = v5.attr("src");
                                                try {
                                                    // 下载 图片
                                                    downImg(src,path);
                                                    // 回调 提示
                                                    // 否则 就报异常
                                                    System.out.println("-> end file Name is -> " + src);
                                                } catch (IOException e) {
                                                    // 错误信息
                                                    System.out.println(e.getMessage());
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


    /**
     * 图片下载
     * 可以优化
     * 多线程 等等
     * 爬取 量少 就不管了
     * @param urlString 图片地址
     * @param path 磁盘路径
     * @throws IOException err
     */
    private static void downImg(String urlString, String path) throws IOException {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5*1000);
        // 输入流
        InputStream is = con.getInputStream();
        // 1M的数据缓冲
        byte[] bs = new byte[1024*1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        File sf=new File(path);
        // 循环 创建 文件夹的
        // 不过 用不上
        // 建议 上面 写好
        if(!sf.exists()){
            boolean b = sf.mkdirs();
        }
        // 扩展名
        String extensionName = urlString.substring(urlString.lastIndexOf(".") + 1);
        // 新的图片文件名 = 编号 +"."图片扩展名
        // 文件名 自己 看着起
        // UUID
        //时间戳
        // random 都可以
        // 我这里 用 random了 随便用的 建议 UUID
        String newFileName = UUID.randomUUID().toString().replace("-" , "") + "." + extensionName;
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
