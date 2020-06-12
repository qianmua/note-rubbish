package _java_es6_;

import java.io.*;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/12  20:51
 * @description :
 */
public class Init {

    /*
    * java es6
    *
    * */

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        ObjectOutputStream stream1 = new ObjectOutputStream(new FileOutputStream("C:\\Users\\HJC\\IdeaProjects\\god-way\\src\\main\\java\\_java_es6_\\demo1.txt" ));
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("C:\\Users\\HJC\\IdeaProjects\\god-way\\src\\main\\java\\_java_es6_\\demo1.txt"));
        Demo3 demo3 = new Demo3();
        Demo3 demo4 = new Demo3();
        Demo3 demo5 = new Demo3();
        stream1.writeObject(demo3);
        stream1.writeObject(demo4);
        stream1.writeObject(demo4);

        System.out.println(stream.readObject());

        stream.close();
        stream1.flush();
        stream1.close();

    }

    class Demo1{
        Demo1(){
            System.out.println("1");
        }
    }

    class Demo2 extends Demo1{
        Demo2(){
            super();
            System.out.println("2");
        }
    }
}
class Demo3 implements Serializable{
    String name  = "6";
    String age  = "6";

    public Demo3() {
    }

    public Demo3(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Demo3{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}


