package _a___________rubbish;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/5
 * @time 16:29
 */
public class Rubbish4 {

    /**
     * 有意思 ， 那么会输出什么，为什么？
     * */
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.b);
    }

    static class A{
        int a = 11;
        A(){
            this.t();
        }

        void t(){
            System.out.println("A" + a);
        }
    }

    static class B extends A{
        int b = 33;
        B(){

        }

        @Override
        void t() {
            System.out.println(b + " " +a + "B");
        }
    }

}

