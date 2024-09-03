public class Practical25 {
    public static void main(String[] args) {
        try {
            // Intentionally throw an exception
            throw new Exception("This is a custom exception message.");
        } catch (Exception e) {
            // Catch the thrown exception and print its message
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
}
