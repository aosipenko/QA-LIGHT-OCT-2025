package org.qa.light.session21;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionFactory {

    private static Connection connection;

    @SneakyThrows
    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        EnvType envType = EnvType.valueOf(
                System.getProperty("env.type", "LOCAL_DEFAULT"));

        switch (envType) {
            case JENKINS_CHROME:
                connection = DriverManager.getConnection(
                        "jdbc:mysql://mysql-db-1:3306/db", "user", "password");
                break;
            default:
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/db", "user", "password");
                break;
        }
        return connection;
    }
}
