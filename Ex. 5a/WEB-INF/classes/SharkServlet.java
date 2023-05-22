import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SharkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sharkSpecies = request.getParameter("sharkSpecies");
        response.setContentType("text/html");
        response.getWriter().println("<h2>You entered: " + sharkSpecies + "</h2>");
    }
}