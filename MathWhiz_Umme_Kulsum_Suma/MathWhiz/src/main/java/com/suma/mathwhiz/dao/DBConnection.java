package com.suma.mathwhiz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/math_whiz_db?useSSL=false&serverTimezone=Asia/Dhaka&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    // Change this to your MySQL password. Keep it private; do not upload real passwords to GitHub.
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
