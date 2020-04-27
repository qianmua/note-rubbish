package _a_juc_._forkJoin_;

import java.util.stream.LongStream;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/27
 * @time 20:15
 */
public class Main {
    /*
    * 并行执行一些任务提高效率
    *
    * 大数据
    *
    * 分支合并
    *
    * 特点 ： 工作窃取
    *
    * A线程执行完了 ， b线程还没执行完， A 把B的偷过来执行
    * 叫做线程窃取
    *
    * forkJoinPool
    *
    * ForkJoinTask
    *
    * */

    public static void main(String[] args) {
        /*
        * 求和计算
        * */
        long sum = 0;
        //jdk7 分隔符 int i = 10_0000_0000
        /*long s = System.currentTimeMillis();
        for (long i = 0; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long e = System.currentTimeMillis();*/
        //stream 并行流

        long s = System.currentTimeMillis();
        //并行\结果
        long reduce = LongStream
                .rangeClosed(0, 10_0000_0000)
                .parallel()
                .reduce(0, Long::sum);
        long e = System.currentTimeMillis();
        System.out.println(e - s + "ms");
    }
}
