public class ProductRepository {
    private Product[] products = new Product[0];
   /* private Book[] books = new Book[0];
    private Smartphone[] smarts = new Smartphone[0]; */

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    /* public void save(Book product) {
        Book[] tmp = new Book[books.length + 1];
        for (int i = 0; i < books.length; i++) {
            tmp[i] = books[i];
        }
        tmp[tmp.length -1] = product;
        books = tmp;
    } */

   /* public void save(Smartphone product) {
        Smartphone[] tmp = new Smartphone[smarts.length + 1];
        for (int i = 0; i < smarts.length; i++) {
            tmp[i] = smarts[i];
        }
        tmp[tmp.length -1] = product;
        smarts = tmp;
    } */

    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }
}
