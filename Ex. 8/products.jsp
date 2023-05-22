<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%
   // Database connection settings
   String url = "jdbc:mysql://localhost:3306/shopping_cart_db";
   String username = "";
   String password = "";
   
   Connection conn = null;
   Statement stmt = null;
   ResultSet rs = null;
   try {
       // Connect to the database
       Class.forName("com.mysql.jdbc.Driver");
       conn = DriverManager.getConnection(url, username, password);
       
       // Execute the query to fetch products
       stmt = conn.createStatement();
       rs = stmt.executeQuery("SELECT * FROM products");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Product List</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
            </tr>
            <% while (rs.next()) { %>
            <tr>
                <td><%= rs.getInt("id") %></td>
                <td><%= rs.getString("name") %></td>
                <td><%= rs.getDouble("price") %></td>
            </tr>
            <% } %>
        </table>
    </div>
</body>
</html>
<%
   } catch (Exception e) {
       e.printStackTrace();
   } finally {
       // Close the database resources
       if (rs != null) {
           rs.close();
       }
       if (stmt != null) {
           stmt.close();
       }
       if (conn != null) {
           conn.close();
       }
   }
%>
