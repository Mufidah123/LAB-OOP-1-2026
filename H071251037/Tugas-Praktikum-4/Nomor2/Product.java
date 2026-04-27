package Nomor2;

public class Product {
    String brand;
    int seriesNumber;
    double price;

    public Product(String brand, int seriesNumber, double price) {
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;
    }

    void displayInfo(){
        System.out.println("Brand : "+brand);
        System.out.println("Serial Number : "+seriesNumber);
        System.out.printf("Price : Rp %.2f", price);
        System.out.println("");
    }
}