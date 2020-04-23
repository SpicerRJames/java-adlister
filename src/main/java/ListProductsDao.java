import java.util.ArrayList;
import java.util.List;

//This is the DAO (Data Access Object/class)
public class ListProductsDao implements Products {
    //Acces product information, list prod, find prod by id, create prod
    private List<Product> products;

    public ListProductsDao(){
        this.products = new ArrayList<>();
        //add some dummy info
        Product hammer = new Product();
        hammer.setId(1);
        hammer.setTitle("A bad hammer");
        hammer.setPriceInCents(3000);
        hammer.setDescription("a bad hammer");
        products.add(hammer);

        Product xbox = new Product();
        xbox.setId(2);
        xbox.setTitle("XBox Series X");
        xbox.setPriceInCents(5000);
        xbox.setDescription("a bad console");
        products.add(xbox);


        Product chiaPet = new Product();
        chiaPet.setId(3);
        chiaPet.setTitle("Vintage chiaPet");
        chiaPet.setPriceInCents(100);
        chiaPet.setDescription("a useless product");
        products.add(chiaPet);
    }

    //Implement our interface requirements


    @Override
    public Product findById(long id) {
        //We want to return the 'Product' Id that is passed in
        return products.get((int)id - 1);

    }

    @Override
    public long createProduct(Product product) {
       //Create a product and insert to our Arraylist (eventually the DB)
        //Assign an ID
        product.setId(products.size()+1);
        //this ID will always be unique

        //add a new Product to the Arraylist
        products.add(product);//When we call the createProduct method
                                //we are sending in a product type object
        //this will add that object to the array list
        return product.getId();

    }
}
