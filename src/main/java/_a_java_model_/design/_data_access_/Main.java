package _a_java_model_.design._data_access_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/24  9:23
 * @description :
 */
public class Main {

    /*
    数据访问对象模式（Data Access Object Pattern）或 DAO 模式用于把低级的数据访问 API 或操作从高级的业务服务中分离出来。
    以下是数据访问对象模式的参与者。

    数据访问对象接口（Data Access Object Interface） - 该接口定义了在一个模型对象上要执行的标准操作。
    数据访问对象实体类（Data Access Object concrete class） - 该类实现了上述的接口。该类负责从数据源获取数据，
    数据源可以是数据库，也可以是 xml，或者是其他的存储机制。
    模型对象/数值对象（Model Object/Value Object） - 该对象是简单的 POJO，
    包含了 get/set 方法来存储通过使用 DAO 类检索到的数据。
     */
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.queryAll()
                .stream()
                .map(Student::getName)
                .forEach(System.out::println);

        if (studentDao.queryById(2).isPresent()) {
            System.out.println(studentDao.queryById(2).get().getName());
        }

    }
}
