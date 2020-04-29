package _a___________rubbish;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/4/25
 * @time 19:15
 */
public class Main {
    public static void main(String[] args) {

//        f1();

        Shape shape = new Circle(10);
        shape.a();
        shape.show();

    }




    private static void f2(){
        List<Character[]> list = new ArrayList<>(500);
        while (true){
            list.add(new Character[1024 * 1024]);
            System.out.println(list.size());
        }
        // 398 OOM


    }

    private static void f1(){
        String str = new Scanner(System.in).next();
        String temp2 = str.replaceAll("[^0-9]","");
        String temp = str.replaceAll("[0-9a-zA-Z]","");
        if (temp.length() <=0){
            System.out.println(str);
        }else {
            System.out.println(temp);
        }
    }
}

abstract class Shape{
    double a;
    double p;
    abstract void a();
    abstract void p();

    void show(){
        System.out.println(a+ " shape " + p);
    }
}

class Circle extends Shape{
    double pi = 3.14;
    double r;

    Circle(double r){
        this.r = r;
    }

    @Override
    void a() {
        a = pi * r * r;
    }

    @Override
    void show() {
        System.out.println( " c" + a);
    }

    @Override
    void p() {

    }
}
