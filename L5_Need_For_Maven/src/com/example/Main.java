package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        // q1. you need to create a table in mysql db using your java application

        // JDBC: Java Database Connectivity (Protocol)
        // Used to connect to relational dbs via java application
        // SMTP - Simple mail transfer protocol
        // HTTP -

        // CREATE a table
        // Adding records in a table
        // Reading records from a table
        // Updating some records in a table
        // Deleting some records in a table

        // 1 - ~65535
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jbdl27", "root", "");

        Statement statement = connection.createStatement();
        statement.execute("create table l5_attendance(id int primary key, name varchar(40))");
    }
}
