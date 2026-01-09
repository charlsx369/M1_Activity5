
public class Main {
    public static void main(String[] args) {

        ATMSystem atmSystem = new ATMSystem();


        System.out.println("=== ATM Withdrawal System ===\n");

        System.out.println("---- Test 1: Valid Withdrawal ----");
        System.out.println("Account=1, Amount=5000");
        atmSystem.processWithdrawal("1", "5000");

        System.out.println("\n---- Test 2: Invalid Account Index ----");
        System.out.println("Account=abc, Amount=5000");
        atmSystem.processWithdrawal("abc", "5000");

        System.out.println("\n---- Test 3: Account Not Found ----");
        System.out.println("Account=10, Amount=5000");
        atmSystem.processWithdrawal("10", "5000");

        System.out.println("\n---- Test 4: Insufficient Funds ----");
        System.out.println("Account=1, Amount=20000");
        atmSystem.processWithdrawal("1", "20000");

        System.out.println("\n=== All tests completed! ===");

    }
}