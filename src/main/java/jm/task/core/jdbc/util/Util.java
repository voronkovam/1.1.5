package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соединения с БД
    private static final String DRIVER_DB = "com.mysql.cj.jdbc.Driver";
    private static final String URL_DB = "jdbc:mysql://localhost:3306/bdkata";
    private static final String USERNAME_DB = "root";
    private static final String PASSWORD_DB = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER_DB);
            connection = DriverManager.getConnection(URL_DB, USERNAME_DB, PASSWORD_DB);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Connection ERROR!");
        }
        return connection;
    }


}
