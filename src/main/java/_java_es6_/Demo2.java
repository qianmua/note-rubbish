package _java_es6_;


import java.io.*;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/12  22:45
 * @description :
 */
public class Demo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student2 s1=new Student2("zhangsan",18,'男');
        Student2 s2=new Student2("zhangsi",18,'男');
        Student2 s3=new Student2("zhangwu",18,'男');
        Student2 s4=new Student2("zhangliu",18,'男');
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        FileInputStream fis=null;
        FileOutputStream fos=null;

        fis=new FileInputStream("C:\\Users\\HJC\\IdeaProjects\\god-way\\src\\main\\java\\_java_es6_\\demo1.txt");
        fos=new FileOutputStream("C:\\Users\\HJC\\IdeaProjects\\god-way\\src\\main\\java\\_java_es6_\\demo1.txt");
        oos=new ObjectOutputStream(fos);
        ois=new ObjectInputStream(fis);
        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.writeObject(s3);
        Object obj=ois.readObject();
        System.out.println(obj);


        ois.close();
        oos.flush();
        oos.close();


    }

}

class Student2 implements Serializable{
    private String name;
    private int age;
    private char sex;
    public Student2(){}
    public Student2(String name,int age,char sex){
        this.name=name;
        this.age=age;
        this.sex=sex;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setSex(char sex){
        this.sex=sex;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public char getSex(){
        return sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}

