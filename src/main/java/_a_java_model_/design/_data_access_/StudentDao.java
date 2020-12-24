package _a_java_model_.design._data_access_;

import java.util.List;
import java.util.Optional;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/24  9:24
 * @description :
 */
public interface StudentDao {
    List<Student> queryAll();

    Optional<Student> queryById(Integer id);
    void updateById(Student student);
    void removeById(Student student);
}
