package _c_java传递_;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/15
 * @time 16:57
 */
public class Main {

    /**
     * 值传递还是引用传递？
     * */
    private static void swap(Users a , Users b){
        //在传递的过程中 拷贝类 对象的地址
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        Users c = a;
        a = b;
        b = c;
        System.out.println("===============");
        //在这里面指向的对象确实改变喽
        //但是只是拷贝了地址
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        //修改的只是 修改了引用地址中的值而已！！
        //修改的是引用地址指向堆内存里面对象的值
    }

    private static void f2(Users s){
        s = new Users("?");
        System.out.println("==============");
        System.out.println(s);
        System.out.println(s.getName());
    }
    private static void f3(String s){
        s = "1";
    }

    public static void main(String[] args) {
        Users users = new Users("张");
        Users users1 = new Users("王");
        swap(users,users1);
        System.out.println(users.getName());
        System.out.println(users1.getName());
        System.out.println(users1);
        f2(users1);

        String ss = "2";
        f3(ss);
        System.out.println(ss);
    }

}
class Users{
    private String name;

    public String getName() {
        return name;
    }

    public Users(String name){
        this.name = name;
    }
}