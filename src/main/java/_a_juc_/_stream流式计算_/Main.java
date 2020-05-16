package _a_juc_._stream流式计算_;

import com.baomidou.mybatisplus.toolkit.MapUtils;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/27
 * @time 19:57
 */
public class Main {

    /*
    * 计算交给流
    * */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.stream()
                .filter( i -> i % 2 == 0)
                .filter( i -> i % 5 != 0)
                .filter( i -> i % 6 != 0)
                .filter( i -> i % 7 != 0)
                .map( integer -> integer + 1)
                //排序  倒叙
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .forEach(System.out::println);


        System.out.println("=============================");
        String name = "my name is god way!";
        Stream.of(name.split(" ")).flatMap(s ->s.chars().boxed()).forEach(System.out::println);


        System.out.println("=============================");

        //并行流
        //.parallel() // 就是并行流 多线程执行。。
        //.sequential() 串行
        IntStream.range(1 , 100).parallel().peek(System.out::println).count();


        // 收集器
        List<Student> list1 = Arrays.asList(
                new Student(1, "A"),
                new Student(2, "B"),
                new Student(3, "C"),
                new Student(4, "D"),
                new Student(5, "E")
        );

        //得到所有ID
        list1.stream().map(Student::getId).collect(Collectors.toSet());

        //分块

        //分组
        Map<Integer, List<Student>> collect = list1.stream().collect(Collectors.groupingBy(Student::getId));
        System.out.println(collect);
    }
}

class Student{
    int id;
    String name;


    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
