package mypackage;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


class Garment {

    public String id;
    public String name;
    public String description;
    public String size;
public String color;
    public double price;
    public int stockQuantity;

Garment(String id, String name, String description, String size, String color, double price, int stockQuantity) {
        this.id = id;
        this.name =    name;
        this.description = description;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
    Garment(String id, String name, double price) {
 this.id = id;
        this.name = name;
        this.price = price;
        
        
        
    }
    void updateStock(int quantity) 
    {
        this.stockQuantity = quantity;
    }
double calculateDiscountPrice(double discountPercentage) 
    {
        return price - (price * discountPercentage / 100);
    }
}
class Fabric {

    public String id;
    
    
    public String type;
    
    public String color;
    
    public double pricePerMeter;

    double calculateCost(double meters)
    {
        return pricePerMeter * meters;
    }
}
class Supplier {

    public String id;
    public String name;
    public String contactInfo;
    List<Fabric> suppliedFabric = new ArrayList<>();

    void addFabric(Fabric fabric) {
        suppliedFabric.add(fabric);
    }

    List<Fabric> getSuppliedFabrics() {
        return suppliedFabric;
    }
}
class Order {

    public String orderId;
    public Date orderDate = new Date();
    public List<Garment> garments = new ArrayList<>();
    private double totalAmount;
    void addGarment(Garment garment) {
        garments.add(garment);
        
        totalAmount += garment.price;
    }

    double calculateTotalAmount() {
        return totalAmount;
    }
    
