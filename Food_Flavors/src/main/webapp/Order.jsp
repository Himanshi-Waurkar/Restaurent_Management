<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Now</title>
    <!-- Include your CSS and other necessary styles/scripts here -->
    <link rel="stylesheet" href="./Order.css">
</head>
<body>
    <h1>Menu</h1>

    <form id="orderForm" method="post" action="ProcessOrderServlet"> <!-- Replace 'ProcessOrderServlet' with your servlet URL -->
        <% 
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "Himanshi@mysql14");
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM menu");

                while (rs.next()) {
        %>
                    <div>
                        <input type="checkbox" name="selectedDishes" value="<%= rs.getString("dish_name") %>">
                        <label><%= rs.getString("dish_name") %> - ₹<%= rs.getDouble("price") %></label>
                    </div>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        %>

        <br>

        <label for="customerName">Customer Name:</label>
        <input type="text" id="customerName" name="customerName" required>

        <br>

        <label for="customerNumber">Customer Number:</label>
        <input type="text" id="customerNumber" name="customerNumber" required>

        <br>

        <button type="submit">Place Order</button>
    </form>
</body>
</html>
