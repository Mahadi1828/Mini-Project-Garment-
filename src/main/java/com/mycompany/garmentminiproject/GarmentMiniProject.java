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
    void printOrderDetails() {
        System.out.println  ("\nOrder ID: " + orderId + " | Date: " + orderDate);
        for (Garment g : garments) {
            System.out.println("Name: " + g.name + " |  Price: $" + g.price + " |  Description: " + g.description);
        }
        System.out.println("Total Amount: $" + calculateTotalAmount());
    }
}

class Inventory {

    List<Garment> garments = new ArrayList<>();

    void addGarment(Garment garment) {
        garments.add(garment);
    }   
    void removeGarment(String id) {
        garments.removeIf(g -> g.id.equals(id));
    }

    Garment findGarment(String id) {
        for (Garment g : garments) {
            if (g.id.equals(id)) {
                return g;
            }
        }
        return null;
    }
    void showInventory() {
        for (Garment g : garments) {
            System.out.println("ID: " + g.id + " | Name: " + g.name + " | Price: $" + g.price);
        }
    }
}
public class OopLabTask3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Garment | 2. View Inventory | 3. Place Order | 4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter Garment ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Description: ");
                String description = scanner.nextLine();
                System.out.print("Enter Size: ");
                String size = scanner.nextLine();
                System.out.print("Enter Color: ");
                String color = scanner.nextLine();
                System.out.print("Enter Price: ");
                double price = scanner.nextDouble();
                System.out.print("Enter Stock Quantity: ");
                int stockQuantity = scanner.nextInt();
                scanner.nextLine();  

                Garment garment = new Garment(id, name, description, size, color, price, stockQuantity);
                inventory.addGarment(garment);
                System.out.println("Garment added successfully.");
