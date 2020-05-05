package _a_jvm_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/5
 * @time 20:14
 */
public class StackOperationTest {

    /**
     *
     * ++i i++ 问题
     */
    void test(){

        int a = 1;
        a = a + 1;

        //第一类
        int a1 = 1;
        a1++;
        int a2 = 1;
        ++a2;

        //第二类
        int a3 = 10;
        int a4 = a3++;

        int a5 = 10;
        int a6 = ++a5;

        //第三类
        int a7 = 10;
        a7 = ++a7;
        int a8 = 10;
        a8 = a8++;

        //第四类
        int i9 = 10;
        int i10 = i9++ + ++i9;

    }
}
