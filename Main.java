import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        HashSet<String> products = new HashSet<>();

        products.add("Laptop");
        products.add("Monitor");
        products.add("Mouse");
        products.add("Keyboard");
        products.add("Printer");

        String choice;
        boolean isRunning = true;

        while (isRunning) {

            // MENU
            System.out.println("1. Search a product");
            System.out.println("2. Add a product");
            System.out.println("3. Print all products and count");
            System.out.println("4. Exit");

            // PROCESS USERS CHOICE
            System.out.print("Enter Choice: ");
            choice = scn.next();
            scn.nextLine();

            switch (choice) {
                case "1" -> searchProduct(products);
                case "2" -> addProduct(products);
                case "3" -> printProduct(products);
                case "4" -> {
                    isRunning = false;
                    System.out.println("\nExiting...");
                }
            }
        }
        scn.close();
      }


    public static void searchProduct(HashSet<String> productSearch) {

        System.out.print("Enter product name to search: ");
        String search = scn.nextLine().trim().toLowerCase();

        boolean found = false;
        for (String product : productSearch) {
            if (product.equalsIgnoreCase(search)) {
                System.out.println("Product found: " + product +"\n");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found!\n");
        }
    }

    public static void addProduct(HashSet<String> productAdd) {

        System.out.print("Enter product name to add: ");
        String addProduct = scn.nextLine();

        if (productAdd.add(addProduct)) {
            System.out.println("Product added: " + addProduct + "\n");
        } else {
            System.out.println("Product already exists.");
        }
    }

    public static void printProduct(HashSet<String> productPrint) {
        System.out.println("\nAll products:");
        for (String product : productPrint) {
            System.out.println(product);
        }
        System.out.println("Total unique products: " + productPrint.size()+ "\n");
    }
}