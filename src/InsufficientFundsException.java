package M4_Activity6;

public class InsufficientFundsException extends Exception {

    double balance;
    double requestedAmount;
    String message;

    public InsufficientFundsException(String message, double balance, double requestedAmount) {
        super(message);
        this.message = message;
        this.balance = balance;
        this.requestedAmount = requestedAmount;

    }

    public String getMessage(){
        return message;

    }
    public double getBalance(){
        return balance;
    }

    public double getRequestedAmount(){
        return requestedAmount;
    }
}
