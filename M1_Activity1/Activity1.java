/**
 * 
 */
package com.bpi.helloworld.main;
import java.util.Scanner;

/**
 * 
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("What is your name? ");

        // Read one line from input
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();   // e.g., Charls

        // Output
        System.out.println("Hello, " + name + "!");

        scanner.close();
    }
}
