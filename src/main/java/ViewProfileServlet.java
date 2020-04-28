import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login.jsp");
        }
    }
}


//        PrintWriter out = new PrintWriter("string");
//        HttpSession session = request.getSession();
//        session.setAttribute("active", true);


//    boolean isActive;
//
//        if(isActive = false){
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
//        } else {
//            out.println(" ");
//