package _a_java_model_.design._3_.struct;

import lombok.*;

import java.util.Observable;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/7  22:50
 * @description :
 */
public class Observer {
    /*
    * 观察者模式
    * 行为模式
    * */
    public static void main(String[] args) {
        Person person = new Person();
        // 注册观察者
        person.addObserver(new MyObServer());

        // 观测的数量
        System.out.println(person.countObservers());

        person.setName("1");
        person.setRealName("2");
    }


    static class MyObServer implements java.util.Observer {

        @Override
        public void update(Observable observable, Object arg) {
            System.out.println("对象发生变化");
        }
    }

    @Getter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    static class Person extends Observable{
        private String name;
        private String realName;

        public void setName(String name) {
            this.name = name;

            //设置对象发生改变
            this.setChanged();
            this.notifyObservers();
        }

        public void setRealName(String realName) {
            this.realName = realName;

            this.setChanged();
            this.notifyObservers();
        }
    }

}
