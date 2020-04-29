import java.sql.Connection;
import java.util.List;

public class MySQLAdsDao implements Ads {


    private Connection connection;

    public MySQLAdsDao(){

    }


    @Override
    public List<Ad> all() {
        return null;
    }

    @Override
    public Long insert(Ad ad) {
        return null;
    }
}
