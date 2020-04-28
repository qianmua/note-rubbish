package _布隆过滤器_;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/28
 * @time 14:24
 */
public class Main {

    /**
     *
     * 布隆过滤器
     *
     * 精度越高，
     * 耗时越长
     *
     * 1000w 插入 5s
     * 0.001 3s
     *
     * 1w 31ms 0.0001
     * 1
     * 0ms
     *
     * 1w 32ms 0.00001
     * 0
     * 0ms
    * */
    public static void main(String[] args) {
        int maxSize = 1_0000;
        double fpp = 0.00001;
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(),maxSize,fpp);

        long k = System.currentTimeMillis();
        for (int i = 0; i < maxSize; i++) {
            filter.put(i);
        }
        long j = System.currentTimeMillis();

        System.out.println((j - k) + " /ms");

        //误判数
        long s = System.currentTimeMillis();
        int count = 0;
        for (int i = maxSize; i < maxSize * 2; i++) {
            if (filter.mightContain(i)){
                count ++ ;
            }
        }

        long e = System.currentTimeMillis();
        System.out.println(count);
        System.out.println((e - s) + " /ms");

    }
}
