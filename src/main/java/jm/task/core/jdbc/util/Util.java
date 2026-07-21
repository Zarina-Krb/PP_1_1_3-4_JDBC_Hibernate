package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/user_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Zarinazarina1993";
    private static SessionFactory sessionFactory;

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к базе данных", e);
        }
    }

    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", URL);
        configuration.setProperty("hibernate.connection.username", USER);
        configuration.setProperty("hibernate.connection.password", PASSWORD);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.format_sql", "true");
        configuration.addAnnotatedClass(User.class);
        sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            return createSessionFactory();
        } else {
            return sessionFactory;
        }
    }
}

