package _2_demo_;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author jinchao.hu
 * @version 1.0
 * @date 2021/1/7  17:57
 * @description :
 */
public class Demo6Stream {

    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        long pi = pi(100);
        long l1 = System.currentTimeMillis();
        System.out.printf("time: %d - values: %d %n" , l1 - l , pi);
    }

    static long pi(long n){
        return LongStream.rangeClosed(2 , n)
                .parallel() // 使用并行流
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    static void charStreamPrint(){
        // int
        // intStream
        "Hello world".chars().forEach(System.out::println);
    }

    static void fileScannerCount(){
        Map<String, Long> f;
        // - - T
        try (Stream<String> words = new Scanner("filePath").delimiter().splitAsStream("?")){
            f = words.collect(Collectors.groupingBy(String::toLowerCase , Collectors.counting()));
        }
        List<String> list = f.keySet().stream()
                .sorted(Comparator.comparing(f::get))
                .limit(10)
                .collect(Collectors.toList());

    }

    static void streamReturnIterable(){

    }

    // foreach 迭代器
    static <E> Iterable<E> iterableOf(Stream<E> stream){
        return stream::iterator;
    }

    // i -> s
    static <E> Stream<E> streamOf(Iterable<E> iterable){
        return StreamSupport.stream(iterable.spliterator() , false);
    }

}
