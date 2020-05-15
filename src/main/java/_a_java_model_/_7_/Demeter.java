package _a_java_model_._7_;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/15
 * @time 21:32
 */
public class Demeter {

    /*
    * 迪米特原则
    *
    * 就是把你自己的实现方法 写在自己的里面
    * 让别人只需要调用就行了
    * 就这样
    *
    * */

    public static void main(String[] args) {
        Management management = new Management();
        management.print(new CollMang());
        management.print2(new EmpMang());
    }
}

class Emp{
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class Coll{
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class CollMang{

    public List<Coll> getAll(){
        List<Coll> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Coll coll = new Coll();
            coll.setId("coll" + i);
            list.add(coll);
        }
        return list;
    }
}

class EmpMang{

    public List<Emp> getAll(){
        List<Emp> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Emp emp = new Emp();
            emp.setId("emp" + i);
            list.add(emp);
        }
        return list;
    }
}

class Management{

    void print(CollMang collMang){
        List<Coll> all = collMang.getAll();
        for (Coll coll : all) {
            System.out.println(coll.getId());
        }
    }

    void print2(EmpMang empMang){
        List<Emp> list = empMang.getAll();
        for (Emp emp : list) {
            System.out.println(emp.getId());
        }
    }

}