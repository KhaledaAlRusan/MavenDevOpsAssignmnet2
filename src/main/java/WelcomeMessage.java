import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@WebServlet(name = "WelcomeServlet", urlPatterns = {"/welcome"})
public class WelcomeMessage extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        String partOfDay;
        if (hour < 12) {
            partOfDay = "Good morning";
        } else {
            partOfDay = "Good afternoon";
        }

        String studentName = request.getParameter("name");
        if (studentName == null) {
            studentName = "Student";
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>" + partOfDay + ", " + studentName + ", Welcome to COMP367</h1></body></html>");
        out.close();
    }
}