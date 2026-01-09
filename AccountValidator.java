public class AccountValidator {


    public void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        if (accountNumber == null) {
            throw new NullPointerException("Account number cannot be null");
        }

        for (char ch : accountNumber.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new InvalidAccountFormatException("Account number must contain only digits");
            }
        }
        if (accountNumber.length() != 10) {
            throw new InvalidAccountNumberException("Account number must be exactly 10 digits");
        }
        System.out.println("Valid account Number: " + accountNumber);
    }

    public void testValidation(String testName, String accountNumber) {
        System.out.println(testName);

        try {
            validateAccountNumber(accountNumber);
        } catch (InvalidAccountNumberException e) {
            System.out.println("Warning: " + e.getMessage());
        } catch (InvalidAccountFormatException e) {
            //contain char
            System.out.println("Warning: " + e.getMessage());
        } catch (NullPointerException e) {
            // null input
            System.out.println("Warning: " + e.getMessage());
        }

        System.out.println();
    }

}
