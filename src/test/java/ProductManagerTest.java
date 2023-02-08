import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(1, "футболка", 550);
    Product product2 = new Product(2, "рассказы", 480);
    Product product3 = new Product(45, "iphone 12", 34800);
    Product product4 = new Product(41, "футболка", 450);
    Product product5 = new Product(251, "iphone 12", 35350);
    Product product6 = new Product(112, "iphone 12", 33450);

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
    }

    @Test
    public void shouldFindProduct() {

        manager.matches(product1, "футболка");

        Product[] expected = {product1, product4};
        Product[] actual = manager.searchBy("футболка");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindBook() {

        manager.matches(product2, "рассказы");

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("рассказы");

        Assertions.assertArrayEquals(expected, actual);

    }
    
    @Test
    public void shouldNotFindProducts() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("");

        Assertions.assertArrayEquals(expected, actual);

    }
    
    @Test
    public void ShouldFindMultipleProducts() {


        Product[] expected = {product3, product5, product6};
        Product[] actual = manager.searchBy("iphone 12");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphone() {

        manager.matches(product3, "iphone 12");

        Product[] expected = {product3};
        Product[] actual = manager.searchBy("iphone 12");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindProductsWithTheSameName() {

        manager.matches(product1, "футболка");

        Product[] expected = {product1, product4};
        Product[] actual = manager.searchBy("футболка");

        Assertions.assertArrayEquals(expected, actual);

    }
}
