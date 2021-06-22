package _a_alg_.leetCode;

import org.junit.Test;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/11  13:28
 */
public class _231 {

    @Test
    public void __231(){
        System.out.println(6 & 1);
    }

    /**
     * n&n-1
     *
     * 按照上述 n=xxxx10000，n-1=xxxx01111
     *
     * xxxx10000
     *
     * xxxx01111
     *
     * -------------
     *
     * xxxx0000
     *
     * 可以看到将原来的最右边的1变为0了。
     *
     * 重复操作，有多少个1，这个操作就可以执行多少次。
     */


    private boolean ipot(int n){
        // 10 100 1000
        if (n <= 0){
            return false;
        }
        if ( (n& n -1) == 0){
            return true;
        }

        return false;

    }

}
