package _2_demo_._3_demo_;

import org.junit.Test;

import java.util.Arrays;

/**
  description :
  
  @author jinchao.hu
  @date 2021/5/24  16:46
  
*/public class Demo1 {

    @Test
    public void m1(){
        int[] arr = {1,2,3};
        int f = 1;
        int[] arr2 = new int[arr.length + 1];
        arr2[0] = 1;
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = arr2[i - 1] ^ arr[i - 1];
        }

        System.out.println(Arrays.toString(arr2));
    }
}
