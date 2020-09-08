package _java_jsonp_;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/8  15:55
 * @description : network // : jj20
 */
@Slf4j
public class JJ20Photo {

    public static final String BASE_PATH = "http://www.jj20.com/bz/ktmh/";

    public static void main(String[] args) {

    }

    /**
     * 扫描分页下所有图片包页面路径
     */
    private List<String> getRootUrlList(String baseKeyWork , Integer pageSize){

        assert pageSize!= null;

        ArrayList<String> list = new ArrayList<>();

        try {
            // base

            for (Integer i = 0; i < pageSize; i++) {
                String s = baseKeyWork + "";

                Document document = Jsoup.parse(new URL(s), 3000);

                document.getAllElements().attr("");
            }
        } catch (IOException e) {
            log.error("downloading root path error : {} " , e.getMessage());
        }
        return list;
    }

    /**
     * 得到图片包基础地址
     * @param keyword 关键字
     */
    private List<String> getNetUrlPathList(String keyword){
        ArrayList<String> list = new ArrayList<>();


        return list;
    }

    /**
     * 根据图包url / 解析得到包含图片大小
     * @param url url
     */
    private void getBasePathNum(String url){

    }


    /**
     * 在图包下分析 得到图片的预览id
     * @param photoUrl t包地址
     */
    private List<String> getPhotoChildrenPath( String photoUrl){
        ArrayList<String> list = new ArrayList<>();

        return list;
    }

    /**
     * 构造原图地址
     * @param childUrl 图片原图地址
     */
    private List<String> imgOriginUrl(String childUrl){
        ArrayList<String> list = new ArrayList<>();


        return list;
    }


    /**
     * 下载图片
     */
    private void downImg(){

    }


}
