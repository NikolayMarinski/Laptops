public class Laptop {
    private int year;
    private String brand;
    private int price;
    private String city;
    private String customerName;

    public Laptop(int year, String brand, int price, String city, String customerName) {
        this.year = year;
        this.brand = brand;
        this.price = price;
        this.city = city;
        this.customerName = customerName;
    }

    public String getBrand() {
        return brand;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
