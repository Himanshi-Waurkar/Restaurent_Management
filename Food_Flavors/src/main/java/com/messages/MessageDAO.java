package com.messages;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {
    static {
        // Load the JDBC driver during class initialization
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("MySQL JDBC Driver not found");
        }
    }

    public static void saveMessage(Message message) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "Himanshi@mysql14")) {
            conn.setAutoCommit(true);

            String query = "INSERT INTO messages (name, email, subject, message) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, message.getName());
                preparedStatement.setString(2, message.getEmail());
                preparedStatement.setString(3, message.getSubject());
                preparedStatement.setString(4, message.getMessage());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   
}

