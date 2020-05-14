package _a_java_model_._7_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/14
 * @time 21:26
 */
public class Segregation1 {

    /**
     * 接口隔离
     * */

    public static void main(String[] args) {

    }
}

interface Intf1{

    void voida();
    void voidb();
    void voidc();
    void voidd();
}

class A implements Intf1{

    @Override
    public void voida() {
        System.out.println("AA");
    }

    @Override
    public void voidb() {
        System.out.println("AB");
    }

    @Override
    public void voidc() {
        System.out.println("AC");
    }

    @Override
    public void voidd() {
        System.out.println("AD");
    }
}

/**
 * 操作。。
 */
class B extends A{

    @Override
    public void voida() {
        System.out.println("BA");
    }

    @Override
    public void voidb() {
        System.out.println("BD");
    }
}