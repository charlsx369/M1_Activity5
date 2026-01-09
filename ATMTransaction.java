public class ATMTransaction {


    public void checkBalance(String accountNumber, double balance) {
        System.out.println("Processing balance inquiry...");

        try {

            int accNum = Integer.parseInt(accountNumber);
            char firstChar = accountNumber.charAt(0);

            String accountType;
            if (firstChar == '1') {
                accountType = "Savings";
            } else if (firstChar == '2') {
                accountType = "Checking";
            } else {
                accountType = "Unknown";
            }

            System.out.println("Account Type: " + accountType);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Current Balance: ₱" + balance);
            System.out.println("Balance inquiry successful!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid account number format! Account numbers must be numeric.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: Account number is empty or invalid!");
        } finally {
            System.out.println("\n========= RECEIPT =========");
            System.out.println("Transaction Date: December 3, 2025");
            System.out.println("Transaction Type: Balance Inquiry");
            System.out.println("ATM Location: Main Branch");
            System.out.println("Thank you for banking with us!");
            System.out.println("===========================\n");
        }
    }

 }

