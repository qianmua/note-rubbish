package _a___________rubbish;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/24
 * @time 15:37
 */
public class Rubbish6 {


    public static void main(String[] args) {
        List<String[]> list = new ArrayList<>(20);
        list.add(new String[]{"A","A11","A12"});
        list.add(new String[]{"A","A21","A22"});
        list.add(new String[]{"A","A31","A32"});
        list.add(new String[]{"B","B11","B12"});
        list.add(new String[]{"B","B21","B22"});
        list.add(new String[]{"B","B31","B32"});
        list.add(new String[]{"C","C11","C12"});
        list.add(new String[]{"C","C21","C22"});

        Map<String[], Long> map = list.stream().collect(Collectors.groupingBy(v1 -> v1, Collectors.counting()));


        Map<String, Long> map1 = list.stream()
                .collect(Collectors.
                        groupingBy(v1 -> v1[0], Collectors.counting()));

        map1.forEach( (s, aLong) -> System.out.println(s));

        System.out.println("//-----------------------------------------//");

        Map<String, List<String[]>> collect = list.stream()
                .collect(Collectors.
                        groupingBy(v1 -> v1[0]));

        collect.forEach( (s, strings) -> strings.forEach( strings1 -> Arrays.stream(strings1).forEach(System.out::println)) );

        System.out.println("//-----------------------------------------//");
        System.out.println("//-----------------------------------------//");


        collect.forEach( (s, strings) -> System.out.println(strings));

        System.out.println("//-----------------------------------------//");

        collect.forEach( (s, strings) -> System.out.println(s) );

        System.out.println("//-----------------------------------------//");


        Map<String, String> map2 = list.stream()
                .collect(Collectors.
                        groupingBy(v1 -> v1[0], Collectors.mapping(v1 -> v1[1]+ "," +v1[2] , Collectors.joining(","))));

        map2.forEach( (s, s2) -> System.out.println(s2));

        System.out.println("//-----------------------------------------//");


        Map<String, List<String[]>> map3 = list.stream()
                .collect(Collectors.
                        groupingBy(v1 -> v1[0], Collectors.mapping(v1 -> v1, Collectors.toList())));

        map3.forEach( (s, strings) -> System.out.println(strings));
    }
}
