package _2_demo_;

import org.junit.Test;

/**
 * @author jinchao.hu
 * @date 2021/1/12  12:02
 * @description :
 */
public class StringLengtTest {
    
    @Test
    public void stringLengthMaxTest(){
        StringBuilder sb = new StringBuilder();
        String s2 = "";
        // time end
        for(int i  = 0 ; i < 655351 ; i++)
//            sb.append('a');
            s2 += "a";
//        String s = sb.toString();

        System.out.println(s2);

        System.out.println(s2.length());
    }
}
