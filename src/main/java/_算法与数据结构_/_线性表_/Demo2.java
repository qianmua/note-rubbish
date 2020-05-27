package _算法与数据结构_._线性表_;

import java.util.Stack;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/27  15:40
 * @description :
 */
public class Demo2 {


    /*
    * 739 每日 温度
    * */


    public static void main(String[] args) {

        int[] arr = {23,24,25,21,19,22,26,23};
        int[] arr2 = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.empty()){
                stack.push(i);
            } else if (arr[i] > arr[stack.peek()]){
                Integer pop = stack.pop();
                arr2[pop] = i - pop;
            }else {
                stack.push(i);
            }
        }
        for (int i : arr2) {
            System.out.print(i + " \t");
        }

    }
}
