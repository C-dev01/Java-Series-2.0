import java.util.Scanner;

class StockItem {
    String itemName;
    int quantity;

    StockItem(String name, int qty) {
        this.itemName = name;
        this.quantity = qty;
    }

    void display() {
        System.out.println(itemName + " | Current Stock: " + quantity + " units");
    }
}

public class StockManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Simulating a small database with an array
        StockItem[] inventory = {
            new StockItem("OPC Cement (50kg)", 500),
            new StockItem("PPC Cement (50kg)", 300),
            new StockItem("Fly Ash", 100)
        };

        System.out.println("--- Ambuja Cements: Digital Inventory Portal ---");
        
        while (true) {
            System.out.println("\n1. View Stock  2. Update Dispatch  3. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                for (StockItem item : inventory) item.display();
            } else if (choice == 2) {
                System.out.print("Enter Item Index (0-2): ");
                int idx = sc.nextInt();
                System.out.print("Enter Quantity Dispatched: ");
                int dispatch = sc.nextInt();
                
                if(inventory[idx].quantity >= dispatch) {
                    inventory[idx].quantity -= dispatch;
                    System.out.println("Update Successful!");
                } else {
                    System.out.println("Alert: Insufficient Stock!");
                }
            } else {
                break;
            }
        }
        System.out.println("System Logged Out.");
    }
}
