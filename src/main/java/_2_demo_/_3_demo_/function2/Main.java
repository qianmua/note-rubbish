package _2_demo_._3_demo_.function2;


/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/5/24  15:57
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        for (int i = 0; i < 100; i++) {
            final int fi = i;
            new Thread( () -> main.mMainC(() -> {} , fi )).start();
        }
    }

    private void mMainC(DemoF demoF , int i) {
        demoF.demofI(System.out::println, (long) i);
    }
}