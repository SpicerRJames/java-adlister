
//This DAO class will provide access to out model data, but will not require accessing the ListProductsDao directly
//Instead we will access the interface
public class DaoFactory {
    private static Ads adsDao;
    private static Products productsDao;

    public static Products getProductsDao(){
        if(productsDao == null){
            productsDao = new ListProductsDao(); //This will only reference to the ListProductsDao class.
        }
        //if it is not null, return the productsDao that already exists
        return productsDao;
    }

    public static Ads getAdsDao(){
        if(adsDao == null){
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }

}
