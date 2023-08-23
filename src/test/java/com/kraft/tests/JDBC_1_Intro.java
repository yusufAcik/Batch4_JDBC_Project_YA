package com.kraft.tests;

import java.sql.*;

public class JDBC_1_Intro {
    public static void main(String[] args) throws SQLException {

        String dbUrl = "jdbc:postgresql://localhost:5432/";
        String dbUsername = "postgres";
        String dbPassword = "185bO188";
        String query = "SELECT * from employees";

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();
        System.out.println("resultSet.getString(2) = " + resultSet.getString(2));

        resultSet.close();
        statement.close();
        connection.close();

    }
}