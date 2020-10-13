package _2020_10_13_.jvm;
//javap -c  Math.class > Math.txt
public class Math {
    public int initData0 = 444; //常量池
    public static int initData1 = 555;
    public static final int initData2 = 666; //常量池
    public static User user = new User(18, "Alice");
    public static final User user2 = new User(19," Bob");

    public int compute(){
        int a = 1;
        int b = 2;
        int c = (a + b)/2;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();

        Math math1 = new Math();
        math1.initData0 = 0;
        math1.compute();

    }
}
