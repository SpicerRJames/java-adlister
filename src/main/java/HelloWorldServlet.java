import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    private int hitCount;

    public void init() {
        // Reset hit counter.
        hitCount = 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        out.println("<h1>Hello, World!" + " " + name.substring(0, 1).toUpperCase() + name.substring(1).toUpperCase() + "</h1>");

        hitCount++;
        PrintWriter out2 = response.getWriter();
        String title = "Total Number of Hits";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out2.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<h2 align = \"center\">" + hitCount + "</h2>\n" +
                "</body> </html>");
    }
    }



//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
//public class HelloWorldServlet extends HttpServlet {
//
//        @Override
//        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.println("<h1>Hello, World!</h1>");
//        }
//
//    }

//    public void init() throws ServletException {
//        message = "Hello World";
//    }
//    public HelloWorldServlet(){
//        super();
//    }
//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//        res.setContentType("text/html");
//        String message = "Hello world";
//        PrintWriter out = res.getWriter();
//        out.println("<html> <body> <h1>" + message + "</h1> </body> </html>");
//    }
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
//        res.setContentType("text/html");
//        PrintWriter out = res.getWriter();
//        out.println("<h1>" + message + "</h1>");
//    }


