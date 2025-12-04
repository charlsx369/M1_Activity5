public class Main {
    public static void main(String[] args) {

     Person charls = new Person("Charls", 27);

        WhiteBoard wb = new WhiteBoard();
        int total = wb.addNumbers(5, 3);

        System.out.println("The total is: " + String.valueOf(total));

    }
}