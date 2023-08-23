package com.kraft.tests;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.*;

public class JDBC_GetDataToList {

    String dbUrl = "jdbc:postgresql://localhost:5432/";
    String dbUsername = "postgres";
    String dbPassword = "185bO188";
    String query = "SELECT * from employees";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(query);

        ResultSetMetaData resultSetMetaData= resultSet.getMetaData();

        List<Map<String , Object>> data=new ArrayList<>();

        int columnCount = resultSetMetaData.getColumnCount();

        while (resultSet.next()){
            Map<String,Object> map = new HashMap<>();
            for (int i = 1; i <=columnCount ; i++) {
                map.put(resultSetMetaData.getColumnName(i),resultSet.getString(i));
            }
            data.add(map);
        }
        System.out.println("data = " + data);
    }
}
