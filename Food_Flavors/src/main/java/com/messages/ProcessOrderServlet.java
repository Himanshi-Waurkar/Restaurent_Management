package com.messages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class ProcessOrderServlet
 */
public class ProcessOrderServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "Himanshi@mysql14");

            // Prepare SQL statement to insert order details
            String sql = "INSERT INTO order_menu (customer_name, customer_number, dish_name) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            // Retrieve form parameters from the request
            String customerName = request.getParameter("customerName");
            String customerNumber = request.getParameter("customerNumber");
            String[] selectedDishes = request.getParameterValues("selectedDishes");

            // Set parameters for the SQL statement and execute it for each selected dish
            if (selectedDishes != null) {
                for (String dish : selectedDishes) {
                    stmt.setString(1, customerName);
                    stmt.setString(2, customerNumber);
                    stmt.setString(3, dish);
                    stmt.executeUpdate();
                }
            }

            // Redirect back to the order page or to a confirmation page
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // You may want to handle exceptions more gracefully and provide appropriate error messages
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
	}

}
