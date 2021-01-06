package main.java.wufan.tool.ConnetMysql8NoSpring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 不使用Spring 连接mysql
 * 程序的耦合
 */
public class ConnetMysqlNoSpring {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        //1 注册驱动
        Connection conn = DriverManager.getConnection("jdbc:mysql://39.107.233.51:3306/testdb","root", "lc1qaz!QAZ");
        //2获取连接
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from account");

        while (rs.next()) {
            for (int i = 1; i <= 3; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }

        rs.close();
        st.close();
        conn.close();

    }

}
