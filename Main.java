
public class Main {
    public static void main(String[] args) {
        BankAccount bankAcct = new BankAccount();

        System.out.println("=== Bank Account Name Display ===\n");
        bankAcct.testCase("ACC-001");
        bankAcct.testCase("ACC-999");

        System.out.println("=== Program completed successfully! ===");
        }
    }
