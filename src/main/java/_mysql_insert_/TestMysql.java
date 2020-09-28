package _mysql_insert_;

import org.junit.Test;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/28  23:45
 * @description :
 */
public class TestMysql {
    @Test
    public void m1(){
        StringBuffer sb = new StringBuffer("insert into test1_insert values('a' , 'b' , 'c' , 'd')");

        for (int i = 0; i < 100000; i++) {
            sb.append(",('a' , 'b' , 'c' , 'd')");
        }
        System.out.println(sb);
    }
}
