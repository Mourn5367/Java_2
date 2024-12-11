package _gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector
{

    private static Connection con = null;

    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
    private static final String USER_NAME = "c##js";
    private static final String PASSWORD = "1234";

    public static Connection getConnection()
    {
        // JDBC Driver Loading(OracleDriver 클래스의 객체가 생성)
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("JDBC Driver Loaded Successfully");
            //Oracle DB와 연결
            con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            System.out.println("JDBC Driver Connected Successfully");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Oracle JDBC Driver not found");
        }
        catch (SQLException e) {
            System.out.println("Oracle DB not Connected");
        }
        return con;
    }
}
