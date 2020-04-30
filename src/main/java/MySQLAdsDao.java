import com.mysql.cj.jdbc.Driver;
import models.Config;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {


    //This class should have a private instance property named connection of
    // type Connection that is initialized in the constructor.
    private Connection connection;

    //Define your constructor so that it accepts an instance of your Config
    // class so that it can obtain the database credentials.
    public MySQLAdsDao()  throws SQLException{
        Config config = new Config();
//
        DriverManager.registerDriver(new Driver());
//
        this.connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
    }


    @Override
    public List<Ad> all() {

       List<Ad> output = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while(rs.next()){
                System.out.println(rs.getString("username"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return output;
    }

    @Override
    public Long insert(Ad ad) {
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    private String createInsertQuery(Ad ad) {
        return "INSERT INTO ads(user_id"
    }

    @Override
    public String connection() {
        return null;
    }

    public static void main(String[] args) throws SQLException {
        Ads ad = new MySQLAdsDao();
//
        System.out.println(ad);
    }
}
