package _java_study_offer_;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/24  14:17
 * @description : 面试宝典
 */
public class Init {

    private int[] arr1 = {1,2,3};
    private final int[] arr2 = arr1;

    @Test
    public void m1(){
        arr2[1] = 3;
        System.out.println(Arrays.toString(arr2));
    }

    @Test
    public void m2(){
        long time = new Date().getTime();
        java.sql.Date date = new java.sql.Date(time);
        System.out.println(date);
    }
}
