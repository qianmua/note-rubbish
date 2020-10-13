package _2020_10_13_.designPatterns;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 * @author ACER
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Student studentA = new Student();
        studentA.setName("管志强");
        Student studentB = new Student();
        studentB.setName("将危机");

        Teacher teacher = new Teacher();
        teacher.addObserver(studentA);
        teacher.addObserver(studentB);

        teacher.publication("开始上课！");
    }
}


class Student implements Observer{
    String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + "收到消息： "+ arg);
    }
}

class Teacher extends Observable{
    public void publication(String content){
        setChanged();
        notifyObservers(content);
    }
}