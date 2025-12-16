import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();

        products.put("Laptop", 30000);
        products.put("Monitor",5000);
        products.put("Mouse",1500);
        products.put("Keyboard",3000);
        products.put("Printer",6500);

        String choice;
        boolean isRunning = true;

        while (isRunning) {

            // MENU
            System.out.println("1. Search a product");
            System.out.println("2. Add a product");
            System.out.println("3. Print all products and prices");
            System.out.println("4. Find the cheapest product");
            System.out.println("5. Exit");

            // PROCESS USERS CHOICE
            System.out.print("Enter Choice: ");
            choice = scn.next();
            scn.nextLine();

            switch (choice) {
                case "1" -> searchProduct(products);
                case "2" -> addProduct(products);
                case "3" -> printProduct(products);
                case "4" -> findProduct(products);
                case "5" -> {
                    isRunning = false;
                    System.out.println("\nExiting...");
                }
            }
        }
        scn.close();
    }


    public static void searchProduct(HashMap<String, Integer> productSearch) {

        System.out.print("Enter product name to search: ");
        String search = scn.nextLine().trim().toLowerCase();

        boolean found = false;

        for (Map.Entry<String, Integer> entry : productSearch.entrySet()) {
            String productName = entry.getKey();
            Integer price = entry.getValue();

            if (productName.equalsIgnoreCase(search)) {
                System.out.println("Product found: " + productName + " Price: " + price + "\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found!\n");
        }
    }


    public static void addProduct(HashMap<String, Integer> productAdd) {

        System.out.print("Enter product name to add: ");
        String addProduct = scn.nextLine();

        if (productAdd.containsKey(addProduct)) {
            System.out.println("Product already exists. Current price: "
                    + productAdd.get(addProduct) + "\n");
            return;
        }
        System.out.print("Enter price: ");
        Integer addPrice = scn.nextInt();

        productAdd.put(addProduct, addPrice);
        System.out.println("Product Added: " + addProduct + "\n");
        }

        
    public static void printProduct(HashMap<String, Integer> productPrint) {

        System.out.println("\nAll products:");

        for (Map.Entry<String, Integer> entry : productPrint.entrySet()) {
            String productName = entry.getKey();
            Integer price = entry.getValue();
            System.out.println(productName + "-" + price);
        }
        System.out.println("Total unique products: " + productPrint.size()+ "\n");
    }

    public static void findProduct(HashMap<String, Integer> productFind) {
            String productName = null;
            int cheapestPrice = Integer.MAX_VALUE;
              for (Map.Entry<String, Integer> entry : productFind.entrySet()) {

            if(entry.getValue() < cheapestPrice){
                productName = entry.getKey();
                cheapestPrice = entry.getValue();
               }
        }
        System.out.println("Cheapest Product: " + productName + " - " + cheapestPrice + "\n");

    }

}
