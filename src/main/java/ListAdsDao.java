import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements Ads {
    private List<Ad> ads;

    public List<Ad> all() {
        if (ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    private List<Ad> generateAds() {
        List<Ad> ads = new ArrayList<>();
        ads.add(new Ad(
            1,
            1,
            "playstation for sale",
            "This is a slightly used playstation"
        ));
        ads.add(new Ad(
            2,
            1,
            "Super Nintendo",
            "Get your game on with this old-school classic!"
        ));
        ads.add(new Ad(
            3,
            2,
            "Junior Java Developer Position",
            "Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript"
        ));
        ads.add(new Ad(
            4,
            2,
            "JavaScript Developer needed",
            "Must have strong Java skills"
        ));
        return ads;
    }

    public Ad findById(long id) {
        //We want to return the 'Product' Id that is passed in
        return ads.getId((int)id - 1);

    }
//
//    @Override
//    public long createAd(Ad ads) {
//        //Create a product and insert to our Arraylist (eventually the DB)
//        //Assign an ID
//        ads.setId(ads.size()+1);
//        //this ID will always be unique
//
//        //add a new Product to the Arraylist
//        ads.add(ads);//When we call the createProduct method
//        //we are sending in a product type object
//        //this will add that object to the array list
//        return ads.getId();
//
//    }
//
//    @Override
//    public String createAUser(){
//        ads.setUserId();
//}
}
