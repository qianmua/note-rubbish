package _java_jdbc_;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/11  22:29
 * @description :
 */
public class Init {

    /*
    *
    * JDCB 原理
    *
    * Class.forName（“com.mysql.jdbc.Driver”）是 强制JVM将com.mysql.jdbc.Driver这个类加载入内存，
    *
    * 并将其注册到DriverManager类，
    *
    * 然后根据DriverManager.getConnection（url，user,pwd）
    *
    * 中的url找到相应的驱动类，
    *
    * 最后调用该该驱动类的connect(url, info)来获得connection对象
    *
    * 在 JDBC的层次上，
    *
    * sun主要定义了1个接口Driver和两个类：
    *
    * DriverManager和DriverInfo。
    *
    * 每个JDBC驱动程序必须实现 Driver接口
    *
    * （在MySql的Connector/J驱动中，这个叫做com.mysql.jdbc.Driver）
    *
    * 而DriverManager 则负责管理所有的Driver对象，包含注册Driver；
    *
    * 选择合适的Driver来建立到某个数据库的连接；
    *
    * 以及进行一些Driver的信息管理等。
    *
    *  DriverInfo非常简单，用于保存Driver的信息，
    *
    * 只有3个成员变量，Driver，DriverClass和 DriverClassName
    *
    *
    * DriverManager
    *
    * private static java.util.Vector drivers = new java.util.Vector();
    *
    * 所有的Driver对象保存在一个Vector数组中。
    *
    * 注册Driver的函数叫registerDriver，将需要注册的Driver对象传入
    *
    * 在一个类加载入内存的时候，类中的静态初始化过程会执行，这样就完成了驱动程序的注册过程
    *
    * 真正实现数据库连接的是Driver对象的connect函数
    *
    * DriverManager.getConnection使用的是一种轮询的方式 （for）
    *
    * 注册的驱动程序越多，连接速度会越慢。JDBC连接数据库的速度很慢
    *
    * jdbc ClassForName暗地里把驱动注册了
    *
    *
    *
    *
    * 1）注册一个驱动
    * 2）使用驱动和数据库连接
    * 3）使用连接对象获取操作数据库的执行对象
    *
    *
    * JDBC中规定，驱动类在被加载时，需要自己“主动”把自己注册到DriverManger中
    *
    *
    * 获取了连接之后，下面可以获取Statement
    *
    * Statement是用来向数据库发送要执行的SQL
    *
    * Statement 的方法:
    *
    * executeUpdate
    * executeQuery 执行查询操作，执行查询操作会返回ResultSet
    *
    *
    *
    * // jdbc 连接
    *
    *  注册驱动
    *
    * 连接数据库
    *
    * 执行 语句
    *
    *
    * jdbc 核心类 接口
    *
    * driverManage connection statement resultSet
    *
    * DriverManage 注册驱动 得到连接
    *
    * Connection 连接数据库 // 可以得到 statement对象
    *
    * statement 用来 与数据库进行交互
    *
    * resultSet 结果集
    * //二维表格
    * 有行有列
    * 操作 结果集 是 移动 内部的指针 来得到数据
    *
    * // 注意  // 同一个 执行的 结果集 只会打印 一次 ，
    * // 下次 想要继续 使用的 时候 需要重新 定向 指针位置
    *
    * //
    * statement 最底层的原理 是 execute()
    * // 执行 语句
    * // 返回 boolean
    * true就是 是一个update insert delete
    * //
    * false 就是 一个 结果集 或者 其他 结果 （创建 表啥的）
    *
    * // 注意 这个 操作啥都可以做 // 包括 创建 表 啥的！！！
    *
    *
    *
    *
    * ORM 就是 封装一些 对应 的字段
    * // 设计模式
    * // 反射
    * // 连接
    * //
    *
    *
    *
    *
    * SQL 执行原理
    *
    * statement：通过jdbc将SQL语句放入数据库，由数据库进行解释操作，这样速度慢
    *
    * PreparedStatement： 将原始的SQL语句进行解释（预编译），
    * 然后将中间码录入数据库，数据库直接执行
    * 缓存SQL来提高性能
    * 参数化防止SQL注入
    *
    *
    *
    *
    *
    *
    *
    * */
}
