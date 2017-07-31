package com.alexander.makarov.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AwsDriverManager {

    private static final String JDBC_CONNECTION_DRIVER = "com.amazon.redshift.jdbc.Driver";

    private static final String USERNAME = "listsbot";
    private static final String PASSWORD = "s37hhx73ru";

    private static final String AWS_INSTANCE_URL = "listsbot.cp5a2cene8zq.ap-southeast-1.rds.amazonaws.com:3306";

    public static Connection getConnection() {

        try {
            Class.forName(JDBC_CONNECTION_DRIVER);
            return DriverManager.getConnection(AWS_INSTANCE_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't initialize jdbc driver...", e);
        } catch (SQLException e) {
          throw new RuntimeException("Can't establish connection to database...", e);
        }
    }

}
