package _a_java_model_._7_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/14
 * @time 22:00
 */
public class OpenClosedPrinciple {

    /**
     * 开闭原则
     * */

    class Base{
        int type;
    }

    /**
     * 修改
     */
    abstract class Base2{
        int type;

        abstract void drow();
    }

    class A extends Base{
        A(){
            type = 1;
        }
    }
    class B extends Base{
        B(){
            type = 2;
        }
    }

    /**
     * 修改
     */
    class C extends Base2{

        @Override
        void drow() {
            System.out.println("c");
        }
    }

    class D extends Base2{

        @Override
        void drow() {
            System.out.println("d");
        }
    }


    /**
     * 不符合开闭原则
     */
    class Use{

        void types(Base base){
            if (base.type == 1)a();
            else b();
        }


        void a(){
            System.out.println("1");
        }
        void b(){
            System.out.println("2");
        }
    }

    /**
     * 修改
     */
    class Use2{
        void types(Base2 base2){
            base2.drow();
        }
    }
}
