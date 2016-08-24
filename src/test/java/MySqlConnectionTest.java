/******************************************************
 * Project Name :  spring_board
 * File Name : MySqlConnectionTest.java
 * Author : nicekkong@gmail.com
 * Create Date : 2016. 6. 29. 오후 11:55
 * Description :
 ******************************************************/

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnectionTest {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/book_ex";
    private static final String USER = "zerock";
    private static final String PWD = "zerock";

    @Test
    public void testConnection() throws Exception {

        Class.forName(DRIVER);

        try(Connection connection = DriverManager.getConnection(URL, USER, PWD)) {
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
