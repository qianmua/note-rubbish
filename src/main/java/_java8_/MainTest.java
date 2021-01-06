package _java8_;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/23  10:23
 * @description : Java8 新特性
 */
public class MainTest {

    /**
     * age > 30
     */
    @Test
    public void m1(){
        List<Emp> emps = DataUtils.getEmployees();
        List<Emp> list = emps.stream().filter(r -> r.getAge() > 30).collect(Collectors.toList());
        list.forEach(System.out::println);

    }

    @Test
    public void m2(){
        Runnable runnable = () -> System.out.println("6");
    }

    @Test
    public void m3(){
        Integer integer = 1;
        // 不可以改变 外部变量的值
        Predicate<Integer> predicate = a -> a + integer >0 ;
        boolean test = predicate.test(3);
    }

    @Test
    public void m4(){
        Function<Integer,Integer> function = r -> r+1;
        Supplier<String> stringSupplier = () -> "6";
    }

    @Test
    public void m5(){
        // (泛型不能接收基本类型)

        // java8 基本类型函数式接口
        IntPredicate intPredicate = r -> r > 0 ;
        boolean b = intPredicate.test(1);

    }

    //方法 引用
    // 用在 lambda 中的
    //

    @Test
    public void m6(){

    }

    //optional
    //  解决 NPE问题
    private Emp emp = new Emp();

    @Test
    public void m7(){
        /*
        * Optional
        * isPresent
        * ifPresent
        * filter
        * map
        * flatMap
        * orElseGet
        * orElseThrow
        * */
        //Objects.requireNonNull(requireNonNull)

        Optional<Emp> emp = Optional.empty();
        Optional.of(null);
        Optional<Emp> emp2 = Optional.of(this.emp);// not null
        Optional<Emp> emp1 = Optional.ofNullable(null);
        Optional<Emp> emp3 = Optional.ofNullable(this.emp);
        // get
        Emp emp4 = emp2.get();

        // 判断 空值
        boolean b = emp.isPresent();
        emp.ifPresent(v -> System.out.println("6")); // 存在 则 执行

        // 操作值
        //filter

        // 操作空值
        //ofElse
        //
    }


    // stream

    @Test
    public void m8(){
        // stream

        // 流一次消费

        // 惰性求知

        // 及早求知

    }

    // api
    @Test
    public void m9(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::println);
        System.out.println("=======");

        // 迭代生成
        Stream<Integer> limit = Stream.iterate(0, r -> r + 2).limit(10);
        limit.forEach(System.out::println);
        System.out.println("=======");
        //数组流
        // Arrays.stream()

        //生成
        Stream<Integer> limit1 = Stream.generate(() -> 1).limit(10);
        limit1.forEach(System.out::println);

        // 筛选 filter distinct // 去重

        // 切片 limit
        // skip 跳过 前三个元素

        //排序
        //sorted // Comparator.comparing()

        //映射

        // 终端操作 -》

        // 匹配 // 终端操作
        // anyMatch // 匹配到第一个就返回
        // allMatch // 匹配到最后一个在返回
        // noneMatch // 取反

        // 查找
        //  findFirst
        // findAll


        // 规约
        //reduce // 将流元素 规约成一个值
        // eg:
        // 所有 的 和

        // max
        // min // 最大最小值

        //count // 求和


        // 收集
        //collect


        // 生成值
        //collectors.counting // 或者count
        //avg //
        // sum //
        // max
        // min
        // summarizing // 统计

        // 分块 分组
        // partitioningBy // 根据 true or false 分块
        // groupBy // 按照 属性分组   一个参数
        //  。。。 groupBy(v1 -> v1 > 1000 ? "搞" : "低" ， Collectors.toList())  两个参数
        // 三个参数  （组，k类型 ， v类型）

        int[] arr = {2,4,5,6,1,5,9,8,7};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        IntSummaryStatistics statistics = Arrays.stream(arr).summaryStatistics();
        System.out.println(statistics);
        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        System.out.println(reduce.orElse(0));
        DoubleSummaryStatistics collect = list.stream().collect(Collectors.summarizingDouble(Double::new));
        IntSummaryStatistics collect1 = list.stream().collect(Collectors.summarizingInt(Integer::new));
        System.out.println(collect);
        System.out.println(collect1);
    }

    @Test
    public void m10(){
        int[] arr = {1,2,3,4};
//        m10_1(arr);
    }
    void m10_1(Integer[] itns){

    }

    @Test
    public void m11(){
        int[] arr = {19,12,11,14,18,8,6,6,13,9,8,3,10,10,1,10,5,12,13,13,9};
        System.out.println(findLucky(arr));
    }

    public int findLucky(int[] arr) {
        int[] fund = new int[501];
        for (int i : arr) {
            fund[i] = fund[i]+1;
        }
        int max = -1;
        // 倒叙
        // 全遍历 。。
        for (int i : arr) {
            if (fund[i] == i){
                max = max > fund[i] ? max : fund[i];
            }
        }
//        return -1;
        return max;
    }


    @Test
    public void m12(){
        // 数值 流
        // IntStream

        // 生成流
        IntStream stream = IntStream.of(1, 2, 3, 4, 5);

        // range
        IntStream range = IntStream.range(1, 10); // [1,10)





    }









}
