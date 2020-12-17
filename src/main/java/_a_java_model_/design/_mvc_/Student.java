package _a_java_model_.design._mvc_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/17  16:49
 * @description :
 */
public class Student {

    private String rollNo;
    private String name;

    public String getRollNo() {
        return rollNo;
    }

    public Student setRollNo(String rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }
}
