package _a_java_model_.design._3_.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/29  22:06
 * @description :
 */
public class ProtoType {

    /*
    * 原型 模式
    *
    * */

    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom" , 1 , "白" , new Date());

        Sheep clone = (Sheep)sheep.clone();
        Sheep clone2 = (Sheep)sheep.clone();
        Sheep clone3 = (Sheep)sheep.clone();
        Sheep clone4 = (Sheep)sheep.clone();
        Sheep clone5 = (Sheep)sheep.clone();
        Sheep clone6 = (Sheep)sheep.clone();

        System.out.println(clone);
        System.out.println(clone2);
        System.out.println(clone3);
        System.out.println(clone4);
        System.out.println(clone5);
        System.out.println(clone6);

        List list = new ArrayList();
        list.add("A");
        list.add("C");
        list.add("B");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("C");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Sheep implements Cloneable{
    private String name;
    private int age;
    private String color;
    private Date date;

    @Override
    protected Object clone()  {

        /*
        * 浅拷贝 只是 将 属性 值 复制一份
        *
        * 对象 的 引用 地址 复制 一份
        *
        * 实际 的指向 地址 还是 原来的
        *
        * 就被叫做 浅拷贝
        *
        * */
        /*
        * 深拷贝 浅拷贝
        *
        * 深拷贝
        *
        * 全部 复制
        *
        * 对整个 对象 进行拷贝
        *
        * */
        Sheep sheep = null;
        Sheep sheep1 = null;
        try {
            sheep = (Sheep) super.clone();

             sheep1 = sheep;

            // 手动处理
            sheep1.date = (Date) date.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return sheep1;
    }
}
