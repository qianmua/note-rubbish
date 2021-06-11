package _a_alg_.leetCode;

import _计算机操作系统_.A;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/11  10:27
 */
public class _169 {

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 n/2的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     */

    @Test
    public void __169(){
        List<Map<String , Integer>> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A" , 1);
        map.put("B" , 1);
        list.add(map);
        map.put("B" , 2);
        list.add(map);
        final Map<Set<String>, Map<String , Integer>> cHMap = new ConcurrentHashMap<>();
        list = list.stream().filter(fMap -> cHMap.put(fMap.keySet() , fMap) == null).collect(Collectors.toList());
        System.out.println(list);

        List<Map<String, Integer>> list1 = new ArrayList<>(list.stream()
                .collect(Collectors.toMap(Map::keySet, m -> m))
                .values());
        System.out.println(list1);
    }

    private int me(int[] nums){
        if (nums.length == 1) {
            return nums[0];
        }
        int n = (nums.length >> 1) + 1;
        // 排序
        Arrays.sort(nums);
        return nums[n];
    }

}
