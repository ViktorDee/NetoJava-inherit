import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(1, "футболка", 550);
    Product product2 = new Book(2, "рассказы", 480, "пушкин");
    Product product3 = new Smartphone(45, "iphone 12", 34800, "china");
    Product product4 = new Product(41, "футболка", 450);
    Product product5 = new Product(56, "торт", 299);
    Product product6 = new Product(31, "футболка красная", 4990);
    Product product7 = new Product(21, "футболка с длинным рукавом", 440);
    Product product8 = new Product(11, "футболка с принтом", 350);
    Product product9 = new Smartphone(455, "iphone 12", 31500, "china");
    Product product10 = new Smartphone(123, "iphone 12", 14900, "china");
    Product product11 = new Book(222, "весна", 210, "ницше");
    Product product12 = new Book(111, "осень", 320, "есенин");
    Product product13 = new Smartphone(13, "nokia", 14100, "japan");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
        manager.add(product9);
        manager.add(product10);
        manager.add(product11);
        manager.add(product12);
        manager.add(product13);
    }

    @Test
    public void shouldFindProduct() {

        Product[] expected = {product5};
        Product[] actual = manager.searchBy("торт");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldFindMultipleProducts() {


        Product[] expected = {product3, product9, product10};
        Product[] actual = manager.searchBy("iphone 12");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProducts() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("ручка");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindBook() {


        Product[] expected = {product2};
        Product[] actual = manager.searchBy("рассказы");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindBookByAuthor() {

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("пушкин");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindSmartphone() {

        Product[] expected = {product13};
        Product[] actual = manager.searchBy("nokia");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindSmartphoneByManufacturer() {

        Product[] expected = {product13};
        Product[] actual = manager.searchBy("japan");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindProductsWithTheSameName() {

        Product[] expected = {product1, product4};
        Product[] actual = manager.searchBy("футболка");

        Assertions.assertArrayEquals(expected, actual);

    }

}
