import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/seashell")
public class SeaShellServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String sessionID = session.getId();

        // Retrieve the sea shell name from the request parameter
        String shellName = request.getParameter("shellName");

        // Update the session attribute with the sea shell name
        session.setAttribute("shellName", shellName);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Sea Shell Web App - Result</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Sea Shell Web App - Result</h1>");
        out.println("<p>Session ID: " + sessionID + "</p>");
        out.println("<p>Sea Shell Name: " + shellName + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
