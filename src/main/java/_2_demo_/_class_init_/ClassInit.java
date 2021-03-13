package _2_demo_._class_init_;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/3/13  13:41
 */
public class ClassInit {

    static {
        System.out.println("Hello");
        int a = 1/0;
        System.out.println("World");
    }

    public static final void DoSomething(){
        System.out.println("doSomething .");
    }
}
