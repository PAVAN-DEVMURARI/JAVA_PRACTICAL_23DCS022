import java.util.Scanner;

public class Practical24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter the first integer : ");
            int x = scanner.nextInt();
            
            System.out.print("Enter the second integer : ");
            int y = scanner.nextInt();
            
            int result = x / y;
            System.out.println("The result of " + x + " / " + y + " is: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter valid integers.");
        } 
    }
}
