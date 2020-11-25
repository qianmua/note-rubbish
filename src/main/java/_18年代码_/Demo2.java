package _18年代码_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/11/25  15:34
 * @description :
 */
public class Demo2 {

    private static int testTryReturn(){
        int a = 1;
        try {
            return a;
        }catch (Exception e){

        }finally {
            a = 2;
        }
        return 0;
    }


    public static void main(String[] args) {
        int i = testTryReturn();

        System.out.println(i);
    }
}
