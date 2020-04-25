package _java_data_type_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * To change this template use File | Settings | File Templates.
 * @date 2020/4/15
 * @time 18:16
 */
public class Demo {
    public static void main(String[] args) {
        Persion a1 = new Persion("A", 1);
        Persion a2 = new Persion("B", 2);
        Persion a3 = new Persion("C", 1);

        System.out.println(a1.eq(a2));
        System.out.println(a1.eq(a3));

        int a = 0xFFFF;
    }
}

class Persion{
    private String name;
    private int age;

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean eq(Persion persion){
        return this.age == persion.age;
    }

}
