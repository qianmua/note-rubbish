package _java8_;

import org.junit.Test;
import org.junit.runner.Runner;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/23  10:23
 * @description :
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

        // 筛选 filter

        // 切片 limit

        //排序
        //sorted // Comparator.comparing()





    }

    @Test
    public void m10(){
        int[] arr = {1,2,3,4};
//        m10_1(arr);
    }
    void m10_1(Integer[] itns){

    }


}
