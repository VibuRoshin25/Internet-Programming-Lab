import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/shiphitcounter")
public class ShipHitCounterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Integer hitCount = (Integer) session.getAttribute("hitCount");

        // Increment the hit count or set it to 1 if it's the first hit
        if (hitCount == null) {
            hitCount = 1;
        } else {
            hitCount++;
        }

        // Update the hit count in the session attribute
        session.setAttribute("hitCount", hitCount);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ship Hit Counter Web App - Result</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Ship Hit Counter Web App - Result</h1>");
        out.println("<p>Hit Count: " + hitCount + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
