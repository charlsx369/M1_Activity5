public class Main {
    public static void main(String[] args) {

        AccountValidator validator = new AccountValidator();

        System.out.println("=== Account Number Validation Test ===");

        validator.testValidation("Test 1: Valid account (1234567890)", "1234567890");

        validator.testValidation("Test 2: Too short (123)", "123");

        validator.testValidation("Test 2: Contains letters (12345ABC90)", "12345ABC90");

        validator.testValidation("Test 4: Contains space (1234 567890)", "1234 567890");

        validator.testValidation("Test 5: Null value", null);
    }
}