import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        
        String[] menuItems = {"Pizza", "Burger", "Pasta", "Salad"};//menu
        double[] prices = {299.00, 249.00, 149.00, 199.00};

        
        int[] cart = new int[menuItems.length];//cart
        
        
        while (isRunning) {
            // Display main menu
            System.out.println("\n=== Food Ordering App ===");
            System.out.println("1. View the Exciting Menu");
            System.out.println("2. View  your cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
        

            int choice = scanner.nextInt();

            
            switch (choice) {
                case 1: // View Menu
                    System.out.println("\n--- Menu ---");
                    for (int i = 0; i < menuItems.length; i++) {
                        System.out.printf("%d. %s - ₹%.2f%n", i + 1, menuItems[i], prices[i]);
                    }

                    System.out.print("Enter the item number to add to cart (or 0 to go back): ");
                    int itemNumber = scanner.nextInt();

                    if (itemNumber > 0 && itemNumber <= menuItems.length) {
                        cart[itemNumber - 1]++;
                        System.out.println("Your delicious "+menuItems[itemNumber - 1] + " added to cart.");
                    } else if (itemNumber != 0) {
                        System.out.println("Invalid choice. Returning to the main menu.");
                    }
                    break;

                case 2: // View Cart
                    System.out.println("\n--- Your Cart ---");
                    boolean isEmpty = true;
                    double total = 0;

                    for (int i = 0; i < cart.length; i++) {
                        if (cart[i] > 0) {
                            System.out.printf("%s x %d - $%.2f%n", menuItems[i], cart[i], cart[i] * prices[i]);
                            total += cart[i] * prices[i];
                            isEmpty = false;
                        }
                    }

                    if (isEmpty) {
                        System.out.println("Your cart is empty.");
                    } else {
                        System.out.printf("Total: $%.2f%n", total);
                    }
                    break;

                case 3: // Checkout
                    System.out.println("\n--- Checkout ---");
                    total = 0;
                    isEmpty = true;

                    for (int i = 0; i < cart.length; i++) {
                        if (cart[i] > 0) {
                            System.out.printf("%s x %d - $%.2f%n", menuItems[i], cart[i], cart[i] * prices[i]);
                            total += cart[i] * prices[i];
                            isEmpty = false;
                        }
                    }

                    if (isEmpty) {
                        System.out.println("Your cart is empty. Add items before checkout.");
                    } else {
                        System.out.printf("Total: $%.2f%n", total);
                        System.out.print("Confirm checkout? (yes/no): ");
                        scanner.nextLine(); 
                        String confirm = scanner.nextLine();

                        if (confirm.equalsIgnoreCase("yes")) {
                            System.out.println("Order placed successfully!");
                            cart = new int[menuItems.length]; // Clear cart
                        } else {
                            System.out.println("Checkout canceled.");
                        }
                    }
                    break;

                case 4: // Exit
                    System.out.println("Thank you for using our Food Ordering App. Goodbye!");
                    isRunning = false;
                    break;

                default: // Invalid Input
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}