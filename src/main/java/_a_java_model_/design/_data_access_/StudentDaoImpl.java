package _a_java_model_.design._data_access_;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/24  9:43
 * @description :
 */
public class StudentDaoImpl implements StudentDao {
    static List<Student> students;

    static {
        students = new ArrayList<Student>();
        Student james = new Student("James", 0);
        Student james2 = new Student("James2", 20);

        students.add(james);
        students.add(james2);
    }

    @Override
    public List<Student> queryAll() {
        return students;
    }

    @Override
    public Optional<Student> queryById(Integer id) {
        return Optional.ofNullable(id < students.size() ? students.get(id) : null);
    }

    @Override
    public void updateById(Student student) {
        if (Optional.ofNullable(student).isPresent()) {
            System.out.println( students.get(student.getAge()) + " update");
        }
    }

    @Override
    public void removeById(Student student) {
    }
}
