package _a_java_model_.design._3_.create;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/7  15:19
 * @description : 构造模式
 */
public class Builder {

    public static void main(String[] args) {
        TypeHouse1 house1 = new TypeHouse1();
        BuildProcess process = new BuildProcess(house1);
        process.make();
        House h = house1.getH();
        System.out.println(h.getF());
        System.out.println(h.getQ());
        System.out.println(h.getD());
    }
}

class BuildProcess{
    private BuildHouse buildHouse;

    BuildProcess(BuildHouse buildHouse) {
        this.buildHouse = buildHouse;
    }
    void make(){
        buildHouse.f();
        buildHouse.q();
        buildHouse.d();
    }
}

// 类型
class TypeHouse1 implements BuildHouse{
    private House house = new House();

    @Override
    public void f() {
        house.setF(this.getClass().getName());
    }
    @Override
    public void q() {
        house.setQ(this.getClass().getName());
    }
    @Override
    public void d() {
        house.setD(this.getClass().getName());
    }
    @Override
    public House getH() {
        return house;
    }
}

//房子2
class TypeHouse2 implements BuildHouse{

    @Override
    public void f() {
        System.out.println(this.getClass().getName());
    }
    @Override
    public void q() {
        System.out.println(this.getClass().getName());

    }
    @Override
    public void d() {
        System.out.println(this.getClass().getName());

    }

    @Override
    public House getH() {
        return new House();
    }
}

// 工人
interface BuildHouse{
    void f();
    void q();
    void d();
    House getH();
}

class House{
    private String f;
    private String q;
    private String d;

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    String getQ() {
        return q;
    }

    void setQ(String q) {
        this.q = q;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
