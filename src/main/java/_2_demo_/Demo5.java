package _2_demo_;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  16:28
 * @description : 函数式接口，基础的几个接口
 */
public class Demo5 {

    /**
     * 接口                   函数签名                demo                    :                    变体
     * UnaryOperator<T>     T apply(T t)            String::toLowerCase     处理后返回             int,long,double
     * BinaryOperator<T>    T apply(T t1, T t2)     BigInteger::add         处理                  int,long,double
     * Predicate<T>         boolean test(T t)       Collection::isEmpty     断言                  int,long,double
     * Function<T>          R apply(T t)            Arrays::asList          处理后返回另一个        int,long,double
     * Supplier<T>          T get()                 Instant::Now            提供                  int,long,double
     * Consumer<T>          void accept(T t)        System.out::println     消费                  int,long,double
     *
     * 各自变体有很多种
     * Supplier 变体 BooleanSupplier
     *
     *
     *
     * all 43.
     */
    public static void main(String[] args) {

    }
}
