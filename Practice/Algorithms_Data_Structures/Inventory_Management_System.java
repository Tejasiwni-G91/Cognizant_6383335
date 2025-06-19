import java.util.HashMap;
import java.util.Scanner;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public void setQuantity(int qty) {
        this.quantity = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: " + price;
    }
}

class Inventory {
    private HashMap<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product p) {
        products.put(p.getProductId(), p);
    }

    public void updateProduct(String id, String name, int qty, double price) {
        if (products.containsKey(id)) {
            Product p = products.get(id);
            p.setProductName(name);
            p.setQuantity(qty);
            p.setPrice(price);
        }
    }

    public void deleteProduct(String id) {
        products.remove(id);
    }

    public void displayAllProducts() {
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}

public class Inventory_Management_System {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Product\n2. Update Product\n3. Delete Product\n4. View All Products\n5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.print("Enter ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();
                System.out.print("Enter Price: ");
                double price = sc.nextDouble();
                inventory.addProduct(new Product(id, name, qty, price));
            } else if (choice == 2) {
                System.out.print("Enter ID to Update: ");
                String id = sc.nextLine();
                System.out.print("Enter New Name: ");
                String name = sc.nextLine();
                System.out.print("Enter New Quantity: ");
                int qty = sc.nextInt();
                System.out.print("Enter New Price: ");
                double price = sc.nextDouble();
                inventory.updateProduct(id, name, qty, price);
            } else if (choice == 3) {
                System.out.print("Enter ID to Delete: ");
                String id = sc.nextLine();
                inventory.deleteProduct(id);
            } else if (choice == 4) {
                inventory.displayAllProducts();
            } else if (choice == 5) {
                break;
            }
        }
        sc.close();
    }
}

