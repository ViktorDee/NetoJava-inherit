public class Smartphone extends Product {
    private String name;
    private String manufacturer;

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

/*    @Override
    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    } */
}
