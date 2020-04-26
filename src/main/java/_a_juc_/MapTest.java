package _a_juc_;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/26
 * @time 20:12
 */
public class MapTest {


    public static void main(String[] args) {

        /**
         *
         * this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
         * 加载因子
         *
         * 构造函数
         *initialCapacity 初始容量 static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
         *
         * 默认负载系数 0.75
         * */
/*
        Map<String, String> map = new HashMap<>();*/
        /*Map<String, String> map = Collections.synchronizedMap(new HashMap<>());*/

        //并发下得hashMap
        /*
        * ConcurrentHashMap
        *
        *
        *
        * */
        Map<String, String> map = new ConcurrentHashMap<>();


        //java.util.ConcurrentModificationException
        for (int i = 0; i < 10; i++) {
            new Thread( () -> {
                map.put(Thread.currentThread().getName() , UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            }).start();
        }

    }
}
