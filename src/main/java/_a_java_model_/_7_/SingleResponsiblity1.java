package _a_java_model_._7_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/14
 * @time 21:18
 */
public class SingleResponsiblity1 {
    /**
     * 单一职责
     * */

}

/**
 * 在run的时候会违反单一职责原则
 */
class V{
    void run(String run){
        System.out.println("路上跑" + run);
    }
}

/**
 * 分开了，代码量大
 */
class V1{
    void run(String s){
        System.out.println("天上" + s);
    }
}

class V2{
    void run(String s){
        System.out.println("地下" + s);
    }
}
class V3{
    void run(String s){
        System.out.println("水里" + s);
    }
}

/**
 * 3
 * 在方法级别上
 */
 class VV{
     void run1(){
         System.out.println("天上");
     }
    void run2(){
        System.out.println("地下");
    }
    void run3(){
        System.out.println("水里");
    }
}


