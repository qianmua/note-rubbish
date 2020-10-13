package _2020_10_13_.basic;

/**
 * try..catch..finally中如果try或者catch中进行了return，finally是否还会执行？
 */
public class TryCatchFinally {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            throw new Exception();
        }catch (Exception e){
            System.out.println("catch");
            return;
        }finally {
            System.out.println("fianlly");
        }
    }
}
