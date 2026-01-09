public class ATMSystem {

    double[] accounts = {10000, 15000, 20000};

    public void processWithdrawal(String accountIndex, String amountInput) {
        try {
            int index = Integer.parseInt(accountIndex);
            double amount = Double.parseDouble(amountInput);

            double balance = accounts[index];

            if (amount > balance) {
                double[] resetAccounts = {10000, 15000, 20000};
                double resetBalance = resetAccounts[index];

                System.out.println("Current balance: ₱" + resetBalance);
                System.out.println("Withdrawal: ₱" + amount);
                System.out.println("Insufficient funds! Cannot withdraw ₱" + amount);

            } else {
                accounts[index] -= amount;
                System.out.println("Current balance: ₱" + balance);
                System.out.println("Withdrawal: ₱" + amount);
                System.out.println("New balance: ₱" + accounts[index]);
                System.out.println("Withdrawal successful!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input!");
            System.out.println("Please enter valid numbers.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Account not found!");
            System.out.println("Invalid account index.");
        } catch (Exception e) {
            System.out.println("Transaction failed!");
        }
    }

}
