package M4_Activity6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccount {
    double balance = 10000;

        private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);

    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {

        logger.info("Withdrawal Requested: ₱{}", amount);

        if (amount < 0){
            logger.error("Invalid withdrawal amount: ₱{}", amount);
                throw new InvalidAmountException("Withdrawal amount must be positive");
        } else if (amount > balance) {
            logger.warn("Insufficient funds: ₱{} available", balance);
                throw new InsufficientFundsException("Insufficient funds for withdrawal", balance, amount);
        }
        else {
            balance -= amount;
            logger.info("Withdrawal completed: ₱{}, New balance: ₱{}", amount, balance);
        }

    }

    public void deposit(double amount) throws InvalidAmountException {
        logger.info("Deposit Requested: ₱{}", amount);
        if (amount <= 0){
            logger.error("Invalid deposit amount: ₱{}", amount);
            throw new InvalidAmountException("Deposit  amount must be positive");
        }

        if (amount > 50000) {
            logger.warn("Large Deposit: ₱{}, - requires verification", amount);
        }

        balance += amount;
        logger.info("Deposit Completed: ₱{}, New balance: ₱{}", amount, balance);
    }

    public static void runTest(BankTestOperation operation, String operationName){


        try {
            operation.execute();
        } catch (InvalidAmountException e) {
            logger.error("{} failed: Deposit amount must be positive.", operationName, e);
        } catch (InsufficientFundsException e) {
            logger.error("{} failed: Insufficient funds for withdrawal", operationName, e);
        }


    }

}
