package _a_java_model_.design._mvc_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/17  16:52
 * @description :
 */
public class Main {

    /*
    MVC 模式
     */
    public static void main(String[] args) {
        Student student = retrieveStudentFromDatabase();


        StudentView view = new StudentView();

        StudentController controller = new StudentController(student , view);

        controller.setStudentName("jinChao.Hu");

        controller.updateView();
    }

    public static Student retrieveStudentFromDatabase(){
        Student student = new Student();
        student.setName("QianMu");
        student.setRollNo("A202010284433");

        return student;
    }

}
