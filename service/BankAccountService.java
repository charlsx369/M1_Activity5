package M4_Activity9.service;

import M4_Activity9.exception.AccountNotFoundException;
import M4_Activity9.exception.InsufficientFundsException;
import M4_Activity9.exception.InvalidAccountException;
import M4_Activity9.exception.InvalidTransferException;
import M4_Activity9.model.BankAccount;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class BankAccountService {
	private static final Logger logger = LoggerFactory.getLogger(BankAccountService.class);


	private static final double MINIMUM_INITIAL_BALANCE = 0.0;
	private List<BankAccount> accounts = new ArrayList<>();

	/**
	 * Creates a new bank account.
	 */
	public void createAccount(String accountNumber, String ownerName, double initialBalance)
			throws InvalidAccountException {

        // TODO 2: Log INFO message "Creating account for owner: {}"
        logger.info("Creating account for owner: {}", ownerName);
		// Parameter: ownerName

		// Validate account number
		if (accountNumber == null || accountNumber.trim().isEmpty()) {

            // TODO 3: Log WARN message "Account creation failed: account number is null or
            // empty"
			logger.warn("Account creation failed: account number is null or empty");

            // TODO 4: Throw InvalidAccountException with message "Account number cannot be
            // null or empty"
            throw new InvalidAccountException("Account number cannot be null or empty");
		}

		// Validate owner name
		if (ownerName == null || ownerName.trim().isEmpty()) {
            logger.warn("Account creation failed: owner name is null or empty");
			// TODO 5: Log WARN message "Account creation failed: owner name is null or
			// empty"
            throw new InvalidAccountException("Owner name cannot be null or empty");
			// TODO 6: Throw InvalidAccountException with message "Owner name cannot be null
			// or empty"
		}

		// Validate initial balance
		if (initialBalance < MINIMUM_INITIAL_BALANCE) {
            logger.warn("Account creation failed: invalid initial balance {}",initialBalance);
			// TODO 7: Log WARN message "Account creation failed: invalid initial balance
			// {}"
			// Parameter: initialBalance
            throw new InvalidAccountException(String.format("Initial balance must be at least %,.2f, Invalid initial balance %,.2f",
                            MINIMUM_INITIAL_BALANCE, initialBalance));
            // TODO 8: Throw InvalidAccountException with formatted message showing min and
			// received balance
			// Use String.format with MINIMUM_INITIAL_BALANCE and initialBalance

		}

		// Check for duplicate account
		if (accountExists(accountNumber)) {
            logger.warn("Account creation failed: account {}, already exists",accountNumber);
			// TODO 9: Log WARN message "Account creation failed: account {} already exists"
			// Parameter: accountNumber
            throw new InvalidAccountException("Account number already exists: {}" + accountNumber);
			// TODO 10: Throw InvalidAccountException with message "Account number already
			// exists: " + accountNumber

		}

		// Create account
		try {
			BankAccount account = new BankAccount(accountNumber, ownerName, initialBalance);
			accounts.add(account);
            logger.info("Account {} created successfully for {}",accountNumber, ownerName);
			// TODO 11: Log INFO message "Account {} created successfully for {}"
			// Parameters: accountNumber, ownerName

		} catch (IllegalArgumentException e) {
            logger.error("Failed to create account due to invalid arguments", e);
			// TODO 12: Log ERROR message "Failed to create account due to invalid
			// arguments" with exception object
			// Pass exception 'e' as last parameter
            throw new InvalidAccountException("Account creation failed",e);
			// TODO 13: Throw InvalidAccountException with message "Account creation failed"
			// and original exception
			// Pass exception 'e' as second parameter
		}
	}

	/**
	 * Transfers money between accounts.
	 */
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount)
			throws AccountNotFoundException, InsufficientFundsException, InvalidTransferException {

        logger.info("Transfer request: {} -> {}, amount: {}", fromAccountNumber, toAccountNumber, amount);
		// TODO 14: Log INFO message "Transfer request: {} -> {}, amount: {}"
		// Parameters: fromAccountNumber, toAccountNumber, amount

		// Validate amount
		if (amount <= 0) {
            logger.warn("Transfer failed: invalid amount {}", amount);
			// TODO 15: Log WARN message "Transfer failed: invalid amount {}"
			// Parameter: amount
            throw new InvalidTransferException(String.format("Transfer amount must be positive. Received: %.2f",amount));
			// TODO 16: Throw InvalidTransferException with formatted message "Transfer
			// amount must be positive. Received: %.2f"
			// Use String.format with amount

		}

		// Validate accounts are different
		if (fromAccountNumber.equals(toAccountNumber)) {
            logger.warn("Transfer failed: same source and destination account {}", fromAccountNumber);
			// TODO 17: Log WARN message "Transfer failed: same source and destination
			// account {}"
			// Parameter: fromAccountNumber
            throw new InvalidTransferException("Cannot transfer from account " + fromAccountNumber + "to itself");
			// TODO 18: Throw InvalidTransferException with message "Cannot transfer from
			// account " + fromAccountNumber + " to itself"

		}

		// Find source account
		BankAccount fromAccount = findAccountByNumber(fromAccountNumber);
		if (fromAccount == null) {
            logger.warn("Transfer failed: source account {} not found", fromAccountNumber);
			// TODO 19: Log WARN message "Transfer failed: source account {} not found"
			// Parameter: fromAccountNumber
            throw new AccountNotFoundException("Source account not found: " + fromAccountNumber);
			// TODO 20: Throw AccountNotFoundException with message "Source account not
			// found: " + fromAccountNumber

		}

		// Find destination account
		BankAccount toAccount = findAccountByNumber(toAccountNumber);
		if (toAccount == null) {
            logger.warn("Transfer failed: destination account {} not found", toAccountNumber);
			// TODO 21: Log WARN message "Transfer failed: destination account {} not found"
			// Parameter: toAccountNumber
            throw new AccountNotFoundException("Destination account not found: " + toAccountNumber);
			// TODO 22: Throw AccountNotFoundException with message "Destination account not
			// found: " + toAccountNumber

		}

		// Check sufficient funds
		if (fromAccount.getBalance() < amount) {
            logger.warn("Transfer failed: insufficient funds in account {}. balance: {}, Required: {}", fromAccountNumber,
                    fromAccount.getBalance(), amount);
			// TODO 23: Log WARN message "Transfer failed: insufficient funds in account {}.
			// Balance: {}, Required: {}"
			// Parameters: fromAccountNumber, fromAccount.getBalance(), amount
            throw new InsufficientFundsException(String.format("Balance: %.2f, Received: %.2f",fromAccount.getBalance(),amount));
			// TODO 24: Throw InsufficientFundsException with formatted message showing
			// balance and required amount
			// Use String.format with fromAccount.getBalance() and amount

		}

		// Perform transfer
		try {
			fromAccount.withdraw(amount);
			toAccount.deposit(amount);
            logger.info("Transfer successful: {} -> {}, amount: {}",fromAccountNumber, toAccountNumber, amount);
			// TODO 25: Log INFO message "Transfer successful: {} -> {}, amount: {}"
			// Parameters: fromAccountNumber, toAccountNumber, amount

		} catch (Exception e) {
            logger.error("Transfer failed due to unexpected error",e);
			// TODO 26: Log ERROR message "Transfer failed due to unexpected error" with
			// exception object
			// Pass exception 'e' as last parameter
            throw new InvalidTransferException("Transfer failed", e);
			// TODO 27: Throw InvalidTransferException with message "Transfer failed" and
			// original exception
			// Pass exception 'e' as second parameter

		}
	}

	/**
	 * Finds account by account number.
	 */
	private BankAccount findAccountByNumber(String accountNumber) {
		if (accountNumber == null) {
			return null;
		}

		for (BankAccount account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
                logger.debug("Account found: {}", accountNumber);
				// TODO 28: Log DEBUG message "Account found: {}"
				// Parameter: accountNumber

				return account;
			}
		}
        logger.debug("Account not found: {}", accountNumber);
		// TODO 29: Log DEBUG message "Account not found: {}"
		// Parameter: accountNumber

		return null;
	}

	private boolean accountExists(String accountNumber) {
		return findAccountByNumber(accountNumber) != null;
	}

	public List<BankAccount> getAllAccounts() {
        logger.debug("Retrieving all accounts, counts: {}", accounts.size());
		// TODO 30: Log DEBUG message "Retrieving all accounts, count: {}"
		// Parameter: accounts.size()

		return new ArrayList<>(accounts);
	}
}
