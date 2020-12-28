package _18年代码_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/28  15:10
 * @description :
 */
public class Demo11 {

    public static void main(String[] args) {
        int fee = 200;

        saveDef:save(fee); // 懵不？
        // 标签 :
        // 打一个标签......
    }

    static void saveDef(){}
    static void save(int fee){}


    // 序列化回调
    // readObject
    // writeObject


    // 动态编译
    // JavaFileObject

    class D11_1{

    }

    class D11_2 extends D11_1{

    }

    class D11_2_1 extends D11_2 {}

    class D11_2_2 extends D11_1 {}

    class D11_3 {
        void m1(){
            D11_2 d112 = new D11_2();
            // 用于对象得判断
            // 基本类型不行
            if (d112 instanceof D11_1){

            }

            if (d112 instanceof D11_2_1){

            }

            D11_2_1 d1122 = new D11_2_1();
            /*if (d1122 instanceof D11_2_2){

            }*/


        }

    }


}
