package com.kraft.tests;

import org.testng.annotations.Test;

import java.sql.*;

public class JDBC_2_Test {
    String dbUrl = "jdbc:postgresql://localhost:5432/";
    String dbUsername = "postgres";
    String dbPassword = "185bO188";
    String query = "SELECT * from employees";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(query);

        resultSet.absolute(3);
        int row = resultSet.getRow();
        System.out.println("row = " + row);

        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println("metaData.getDriverVersion() = " + metaData.getDriverVersion());
        System.out.println("metaData.getUserName() = " + metaData.getUserName());
        System.out.println("metaData.getDatabaseProductName() = " + metaData.getDatabaseProductName());

        //tablo metadatası
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        int columnCount = resultSetMetaData.getColumnCount();

        System.out.println("columnCount = " + columnCount);

        String columnName = resultSetMetaData.getColumnName(4);
        System.out.println("columnName = " + columnName);
    }
}
