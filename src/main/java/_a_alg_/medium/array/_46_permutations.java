package _a_alg_.medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rtliu
 * @Date: 2020/7/14 上午9:36
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: 1
 *`         Given a collection of distinct integers, return all possible permutations.
 *`      Example:
 *`         Input: [1,2,3]
 *`         Output: [   [1,2,3],   [1,3,2],   [2,1,3],   [2,3,1],   [3,1,2],   [3,2,1] ]
 * @Version: 1.0
 */
public class _46_permutations {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        backTrace(answer, new ArrayList<>(), nums);
        return answer;

    }

    /**
     * 递归遍历
     * @param answer
     * @param list
     * @param nums
     */
    private static void backTrace(List<List<Integer>> answer, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            // 如果有这个数字，就跳过
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            backTrace(answer, list, nums);
            list.remove(list.size() - 1);
        }


    }

}
