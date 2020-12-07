package _18年代码_;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/7  8:46
 * @description :
 */
public class Demo10 {


    public static void main(String[] args) {
        m1();
    }

    private static void m1(){
        // json trans

        ArrayList<String> stringDemoList = new ArrayList<String>(){{
            add("A");
            add("B");
            add("C");
        }};

        System.out.println(stringDemoList);

        String s = JSON.toJSONString(stringDemoList);

        System.out.println(s);

        List list = JSON.parseObject(s, List.class);
        System.out.println(list);
    }
}
