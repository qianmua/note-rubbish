package _gaussdb_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/12/25  11:07
 * @description :
 */
public class Dao extends ConnBase{

    public static void main(String[] args) {
        Dao dao = new Dao();
        try {
            dao.queryAll();

        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
    }

    public void queryAll() throws SQLException {

        Connection conn = this.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select user_rrn,user_name,local_name,password from user_profile ");
            rs = ps.executeQuery();
            while(rs.next()) {
                System.out.print(rs.getString(1) + " \t");
                System.out.print(rs.getString(2) + " \t");
                System.out.print(rs.getString(3) + " \t");
                System.out.print(rs.getString(4) + " \t");
                System.out.println();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps != null) {
                ps.close();
            }
        }
    }
}
