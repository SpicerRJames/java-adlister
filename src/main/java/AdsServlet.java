import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdsServlet", urlPatterns = "/ads")
public class AdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //1. Want to call the DAO factory to get all of the adds
        Ads siteAds = DaoFactory.getAdsDao();

        //All site ads contains every ad that has been added to the site
        ArrayList<Ad> allSiteAds = (ArrayList<Ad>) siteAds.all();
        request.setAttribute("adsList", allSiteAds);
        request.getRequestDispatcher("ads/index.jsp").forward(request, response);
    }
}
