package _18年代码_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/11/16  17:38
 * @description :
 */
public class Demo {

    public static void main(String[] args) {
        try{
            System.out.println("A");
//            throw new RuntimeException("one exception");
            int c = 1/0;
        }catch (RuntimeException e){
            e.printStackTrace();
        }finally {
            try {
                System.out.println("B");
//                throw new ("two exception");
                int a = 1/0;
            }catch (RuntimeException e){
                e.printStackTrace();
            }
            System.out.println("C");
        }

        System.out.println("OK");
    }
}
