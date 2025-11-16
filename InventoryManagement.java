import java.util.Scanner;

public class InventoryManagement {

    // Safe input for all integers
    public static int safeIntInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid! Enter a valid number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String productName[] = new String[100];
        int price[] = new int[100];
        int quantity[] = new int[100];
        int count = 0;

        while (true) {
            System.out.println("\n=========== INVENTORY MENU ===========");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Sort by Price");
            System.out.println("6. Sort by Quantity");
            System.out.println("7. Display All Products");
            System.out.println("8. Show Inventory Summary");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int ch = safeIntInput(sc);

            switch (ch) {

                // Add Product
                case 1:
                    System.out.print("Enter product name: ");
                    productName[count] = sc.next();

                    System.out.print("Enter price: ");
                    price[count] = safeIntInput(sc);

                    System.out.print("Enter quantity: ");
                    quantity[count] = safeIntInput(sc);

                    count++;
                    System.out.println("✔ Product added successfully!");
                    break;

                // Search Product
                case 2:
                    System.out.print("Enter product name to search: ");
                    String searchKey = sc.next();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (productName[i].toLowerCase().contains(searchKey.toLowerCase())) {
                            System.out.println("\nProduct Found:");
                            System.out.println("Name: " + productName[i]);
                            System.out.println("Price: Rs." + price[i]);
                            System.out.println("Quantity: " + quantity[i]);
                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("❌ Product not found!");
                    break;

                // Update Product
                case 3:
                    System.out.print("Enter product name to update: ");
                    String updateName = sc.next();
                    boolean updated = false;

                    for (int i = 0; i < count; i++) {
                        if (productName[i].equalsIgnoreCase(updateName)) {

                            System.out.print("Enter new price: ");
                            price[i] = safeIntInput(sc);

                            System.out.print("Enter new quantity: ");
                            quantity[i] = safeIntInput(sc);

                            System.out.println("✔ Product updated successfully!");
                            updated = true;
                        }
                    }

                    if (!updated)
                        System.out.println("❌ Product not found!");
                    break;

                // Delete Product
                case 4:
                    System.out.print("Enter product name to delete: ");
                    String deleteName = sc.next();
                    boolean deleted = false;

                    for (int i = 0; i < count; i++) {
                        if (productName[i].equalsIgnoreCase(deleteName)) {

                            for (int j = i; j < count - 1; j++) {
                                productName[j] = productName[j + 1];
                                price[j] = price[j + 1];
                                quantity[j] = quantity[j + 1];
                            }

                            count--;
                            System.out.println("✔ Product deleted successfully!");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted)
                        System.out.println("❌ Product not found!");
                    break;

                // Sort by Price
                case 5:
                    for (int i = 0; i < count - 1; i++) {
                        for (int j = i + 1; j < count; j++) {
                            if (price[i] > price[j]) {

                                int tp = price[i]; price[i] = price[j]; price[j] = tp;
                                int tq = quantity[i]; quantity[i] = quantity[j]; quantity[j] = tq;
                                String tn = productName[i]; productName[i] = productName[j]; productName[j] = tn;
                            }
                        }
                    }
                    System.out.println("✔ Sorted by price!");
                    break;

                // Sort by Quantity
                case 6:
                    for (int i = 0; i < count - 1; i++) {
                        for (int j = i + 1; j < count; j++) {
                            if (quantity[i] > quantity[j]) {

                                int tq = quantity[i]; quantity[i] = quantity[j]; quantity[j] = tq;
                                int tp = price[i]; price[i] = price[j]; price[j] = tp;
                                String tn = productName[i]; productName[i] = productName[j]; productName[j] = tn;
                            }
                        }
                    }
                    System.out.println("✔ Sorted by quantity!");
                    break;

                // Display All Products
                case 7:
                    System.out.println("\n=========== PRODUCT LIST ===========");
                    System.out.printf("%-15s %-10s %-10s\n", "Name", "Price", "Quantity");
                    System.out.println("---------------------------------------");

                    for (int i = 0; i < count; i++) {
                        System.out.printf("%-15s %-10d %-10d", productName[i], price[i], quantity[i]);

                        if (quantity[i] < 5)
                            System.out.print("   ⚠ Low Stock!");

                        System.out.println();
                    }
                    break;

                // Inventory Summary
                case 8:
                    if (count == 0) {
                        System.out.println("Inventory is empty!");
                        break;
                    }

                    int totalValue = 0;
                    int maxPrice = price[0], minPrice = price[0];
                    String maxProduct = productName[0], minProduct = productName[0];

                    for (int i = 0; i < count; i++) {
                        totalValue += price[i] * quantity[i];

                        if (price[i] > maxPrice) {
                            maxPrice = price[i];
                            maxProduct = productName[i];
                        }

                        if (price[i] < minPrice) {
                            minProduct = productName[i];
                            minPrice = price[i];
                        }
                    }

                    System.out.println("\n=========== INVENTORY SUMMARY ===========");
                    System.out.println("Total Products: " + count);
                    System.out.println("Total Stock Value: Rs." + totalValue);
                    System.out.println("Most Expensive Product: " + maxProduct + " (Rs." + maxPrice + ")");
                    System.out.println("Cheapest Product: " + minProduct + " (Rs." + minPrice + ")");
                    break;

                case 9:
                    System.out.println("Exiting… Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }
}

