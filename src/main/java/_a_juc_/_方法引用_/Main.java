package _a_juc_._方法引用_;

import java.util.function.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/16
 * @time 11:23
 */
public class Main {

    /*
    * jdk 默认 把当前实例传入非静态方法，参数名是this
    * 位置在第一个
    * */

    /*
    * 方法引用
    * */

    public static void main(String[] args) {
        //方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("6");

        /*静态方法的方法引用*/
        Consumer<String> consumer1 = Test::say;
        consumer.accept("????");

        /*非静态对象引用*/
        Function<String , Integer> function = new Test()::eat;
        function.apply("a");

        UnaryOperator<String> unaryOperator = new Test()::eat2;
        unaryOperator.apply("7777");

        BiFunction<Test , String , Integer> biFunction = Test::eat;
        biFunction.apply(new Test() , "???");

        //构造函数的方法引用
        //返回一个新对象
        Supplier<Test> supplier = Test::new;
        Test test = supplier.get();

        Function<String , Test> function1 = Test::new;
        Test test1 = function1.apply("真溜");




    }

}

class Test{

    public Test(){
    }
    public Test(String name){
        System.out.println("空空空空空空空空空"+ name);
    }

    public static void say(String a){
        System.out.println("say 66" + a);
    }

    public static void say(Test test) {
        System.out.println("say 66" + test);

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int eat(String eat){
        System.out.println("eat + 我已经不想吃狗粮了" + eat);
        return 100;
    }
    public String eat2(String eat){
        System.out.println("eat + 我已经不想吃狗粮了" + eat);
        return "6666";
    }
}
