package M4_Activity6;


public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        bankAccount.runTest(() -> bankAccount.deposit(5000),"Deposit");
        bankAccount.runTest(() -> bankAccount.withdraw(3000),"Withdrawal");
        bankAccount.runTest(() -> bankAccount.deposit(-500),"Deposit");
        bankAccount.runTest(() -> bankAccount.withdraw(20000),"Withdrawal");
        bankAccount.runTest(() -> bankAccount.deposit(60000),"Deposit");
    }
}