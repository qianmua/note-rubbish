package _java8_;

import org.junit.Test;
import org.junit.runner.Runner;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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




}
