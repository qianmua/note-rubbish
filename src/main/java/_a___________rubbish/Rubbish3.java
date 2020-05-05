package _a___________rubbish;

/**
 * Created by IntelliJ IDEA.
 *
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/5/4
 * @time 19:32
 */
public class Rubbish3 {
//http://maven.aliyun.com/nexus/content/groups/public/
    public static void main(String[] args) {
        new B();
    }
}

class A{
    String a = "hello";
}
class B extends A{
    B(){
        System.out.println(super.a);
    }
}
