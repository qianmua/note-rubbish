package _2020_10_13_.designPatterns;

/**
 * 适配器模式
 * @author ACER
 */
public class Adapter implements Target {
    People people;

    public Adapter(People people) {
        this.people = people;
    }

    @Override
    public String get() {
        return people.toString();
    }

    public static void main(String[] args) {
        People people = new People("gzq", 25);
        Adapter adapter = new Adapter(people);
        System.out.println(adapter.get());
    }
}

interface Target{
    String get();
}

class People{
    String name;
    int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

