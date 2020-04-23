public interface Products {

    // this method will return an object of of type "Product"
    Product findById(long id);

    //this method will insert a 'Product; into our table,
    // return of this will be said products ID
    long createProduct(Product product);

}
