package _a_alg_.leetCode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @date ：Created in 2021/5/31 9:32
 * @version: java 8
 * list<Map<>>去重
 */
public class ListMap {
    public static void main(String[] args) {
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map5 = new HashMap<>();

        Map<String,Object> map6 = new HashMap<>();
        Map<String,Object> map7 = new HashMap<>();
        Map<String,Object> map8 = new HashMap<>();
        map6.put("123","李宁");
        map6.put("234","李宁2");
        map6.put("key","000");
        map7.put("123","刘备");
        map7.put("234","孙权");
        map7.put("key","111");
        map8.put("123","李宁");
        map8.put("234","孙权");
        map8.put("key","222");
        map1.put("223","张飞");
        map1.put("123","李宁");
        map1.put("key","000");
        map5.put("345","关羽");
        map5.put("234","孙权");
        map5.put("key","111");
        list.add(map1);
        list.add(map6);
        list.add(map7);
        list.add(map8);
        list.add(map5);

        ArrayList<Map<String, Object>> list1 = new ArrayList<>(list.stream()
                .collect(Collectors.toMap(k -> k.get("key"), v -> v , (m1 , m2) -> m1)).values());
        /*list.stream()
                .sorted( (o , n) -> {
                    Set<String> oK = o.keySet();
                    Set<String> nK = n.keySet();


                    return 1;
                })*/
        System.out.println(list1);

    }
}
