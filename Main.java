import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> products = new ArrayList<>();

        products.add("Laptop");
        products.add("Mouse");
        products.add("Keyboard");
        products.add("Monitor");
        products.add("Printer");

        System.out.println("All products:");
        printAll(products);

        products.add("Webcam");
        boolean removed = products.remove("Mouse");
        System.out.println("\nAfter adding and removing products:");
        printAll(products);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String search = scanner.nextLine();

        boolean found = false;
        for (String product : products) {
            if (product.equalsIgnoreCase(search)) {
                System.out.println("Product found: " + product);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
        scanner.close();
    }

    private static void printAll(List<String> product) {

        for (int i = 0; i < product.size(); i++) {
            System.out.println((i + 1) + ". " + product.get(i));
        }

    }
}