package _2020_10_13_.basic;

/**
 * java中final的用法
 */

public class FinalUse extends Father {//, Son{ //final类无法被继承
//    final int version; //会报错，因为final必须赋值
    final static int version = 1;

    //注意：无法重写父类的final方法
    @Override
    protected void marry() {
        System.out.println("儿子也结婚啦！");
    }

    public static void main(String[] args) {
//        version = 2;//报错，无法修改
        Person person = new Person();
        person.age = 25;
        person.name = "gzq";//final类对象是可以修改值的
        FinalUse finalUse = new FinalUse();
        finalUse.marry();
    }

    final static class Person{
        int age;
        String name;
    }
}

class Father{
    final int age = 80;

    protected  final void giveBirth(){
        System.out.println("生宝宝！");
    }

    protected void marry(){
        System.out.println("结婚！");
    }

}

final class Son{
    final int age = 10;

    protected  final void giveBirth(){
        System.out.println("生宝宝！");
    }

    protected void marry(){
        System.out.println("结婚！");
    }

}
