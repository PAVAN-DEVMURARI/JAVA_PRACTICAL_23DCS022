// Custom exception class
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class Practical26 {
    // Method that throws the custom exception
    public static void validate(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("Age must be 18 or above.");
        }
    }

    public static void main(String[] args) {
        try {
            validate(16); // This will throw the custom exception
        } catch (CustomException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
}
