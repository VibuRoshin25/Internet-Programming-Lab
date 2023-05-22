import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoralServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection connection;

    public void init() throws ServletException {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/corals_db";
            String username = "";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Execute a SQL query to retrieve corals from the database
            String sql = "SELECT * FROM corals";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Display the retrieved corals
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Corals</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>List of Corals</h1>");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String color = resultSet.getString("color");

                out.println("<p><strong>Name:</strong> " + name + "</p>");
                out.println("<p><strong>Type:</strong> " + type + "</p>");
                out.println("<p><strong>Color:</strong> " + color + "</p>");
                out.println("<br>");
            }

            out.println("</body>");
            out.println("</html>");

            // Clean up resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            // Close the database connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
