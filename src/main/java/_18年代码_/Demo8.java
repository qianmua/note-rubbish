package _18年代码_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/3  15:44
 * @description :
 */
public class Demo8 {


    public static void main(String[] args) {
        // 5x 3y 1/5 z
        // 25x + 15 + z
        // 100
        // 100
        int x = 0;
        for (int i = 0; i <= 100; i++) {
            for (int i1 = 0; i1 <= 100; i1++) {
                for (int i2 = 0; i2 <= 100; i2++) {
                    if ( ((i*25) + (15 * i1) + (i2 ) == 500) && ( (i + i1 + i2 ) == 100) ){
                        System.out.println(++x);
                        System.out.println(i + " " + i1 + " " + i2);
                    }
                }
            }
        }
    }
}
