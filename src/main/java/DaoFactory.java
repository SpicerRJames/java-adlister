import models.Config;

import java.sql.SQLException;

public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() throws SQLException {
        if (adsDao == null) {
            Config con = new Config();
            adsDao = new MySQLAdsDao();
        }
        return adsDao;
    }
}
