package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соединения с БД
    private static final String DRIVER_DB = "com.mysql.cj.jdbc.Driver";
    private static final String URL_DB = "jdbc:mysql://localhost:3306/bdkata";
    private static final String USERNAME_DB = "root";
    private static final String PASSWORD_DB = "root";

    private static Connection connection;
    private static SessionFactory sessionFactory;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DRIVER_DB);
                connection = DriverManager.getConnection(URL_DB, USERNAME_DB, PASSWORD_DB);

            } catch (SQLException | ClassNotFoundException e) {
                System.err.println("Connection ERROR!");
            }
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties properties = new Properties();
                properties.put(Environment.DRIVER, DRIVER_DB);
                properties.put(Environment.URL, URL_DB);
                properties.put(Environment.USER, USERNAME_DB);
                properties.put(Environment.PASS, PASSWORD_DB);
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                properties.put(Environment.HBM2DDL_AUTO, "");

                configuration.setProperties(properties);
                configuration.addAnnotatedClass(User.class);

                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}



