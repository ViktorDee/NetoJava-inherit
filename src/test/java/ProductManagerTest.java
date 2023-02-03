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

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
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
