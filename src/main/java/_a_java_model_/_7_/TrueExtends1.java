package _a_java_model_._7_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/14
 * @time 21:44
 */
public class TrueExtends1 {
    /**
     * 里氏替换
     * */

    class Base{}

    class A extends Base{
        int f(int a ,  int b){
            return a-b;
        }
    }

    class B extends Base{
        /**
         * A 有他的实现 但是这里只是写了个f1 f2 无意中重写了f
         * 要是new B 的时候想去调用A呢？
         * 逻辑就有问题了
         * 解决 创建Base类
         * 提升关系，使用组合
         * @param a
         * @param b
         * @return
         */
        int f(int a, int b) {
            return a+b;
        }

        int f2(int a , int b){
            return a*b;
        }

        /**
         * 修改
         *
         * 调用功能就会很明确
         */
        private A a = new A();
        int f3(){
            return a.f(1,2);
        }
    }
}
