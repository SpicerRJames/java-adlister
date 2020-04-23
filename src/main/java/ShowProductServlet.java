//This servlet will be used to listen for users trying to view all
//of the products - likely by going to a page like "/products"


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowProductsServlet", urlPatterns = "/products/show")
public class ShowProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // check to see if there is an id passed in the url parameters
            // i.e . http://localhost:8080/products/show?id=27
        long productId = Long.parseLong(request.getParameter("id"));

        Products productDao = DaoFactory.getProductsDao();

        Product product = productDao.findById(productId);

        request.setAttribute("product", product);
        request.getRequestDispatcher("/products/product-show.jsp").forward(request, response);

    }

}
