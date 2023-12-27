import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
    class Product {
        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void reduceQuantity(int soldQuantity) {
            if (soldQuantity <= quantity) {
                quantity = quantity-soldQuantity;
            } else {
                System.out.println("Error: Insufficient quantity in stock.");
            }
        }
    }

    class Inventory {
        private Map<String, Product> products;

        public Inventory() {
            this.products = new HashMap<>();
        }

        public void addProduct(Product product) {
            products.put(product.getName(), product);
        }

        public void displayInventory() {
            System.out.println("Inventory Status:");
            for (Product product : products.values()) {
                System.out.println(product.getName() + " - Price: $" + product.getPrice() +
                        " - Quantity: " + product.getQuantity());
            }
            System.out.println();
        }

        public Product getProduct(String productName) {
            return products.get(productName);
        }

        public void sellProduct(String productName, int quantity) {
            Product product = products.get(productName);
            if (product != null) {
                product.reduceQuantity(quantity);
            } else {
                System.out.println("Error: Product not found.");
            }
        }
    }

    public class MainApp {
        public static void main(String[] args) {
            Inventory inventory = new Inventory();

            // Adding sample products to the inventory
            inventory.addProduct(new Product("Laptop", 999.99, 10));
            inventory.addProduct(new Product("Smartphone", 499.99, 20));
            inventory.addProduct(new Product("Tablet", 299.99, 15));

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. Display Inventory");
                System.out.println("2. Sell Product");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        inventory.displayInventory();
                        break;
                    case 2:
                        sellProduct(inventory, scanner);
                        break;
                    case 3:
                        System.out.println("Exiting the program. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private static void sellProduct(Inventory inventory, Scanner scanner) {
            System.out.print("Enter the product name: ");
            String productName = scanner.nextLine();

            System.out.print("Enter the quantity to sell: ");
            int quantity = scanner.nextInt();

            inventory.sellProduct(productName, quantity);
        }
    }


