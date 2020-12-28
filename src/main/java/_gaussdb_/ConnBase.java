package _gaussdb_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/25  11:01
 * @description :
 */
public class ConnBase {
    private String url = "jdbc:zenith:@***.**.***.*:10000"; // 连接字符串
    private String dbUserName = "****";                  // 用户名
    private String dbUserPwd = "***********";                 // 密码
    protected Connection conn = null;


    public Connection getConnection() {
        if (conn != null)
            return conn;

        try {
            // 加载驱动类
            Class.forName("com.huawei.gauss.jdbc.ZenithDriver");
            // 获取数据库连接
            conn = DriverManager.getConnection(url, dbUserName, dbUserPwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        return conn;
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*public static void main(String [] args) {
        new ConnBase().getConnection();
    }*/




}
