
import java.util.InputMismatchException;
import java.util.Scanner;

public class Practical24 {
    public static void main(String[] args) {
        int a,b;
        Scanner input = new Scanner(System.in);
       
        try {
            System.out.println("Enter the value of a: ");
            a = input.nextInt();
            System.out.println("Enter the value of b: ");
            b = input.nextInt();
            int c = a/b;
            System.out.println("The value of c is: " + c);
        } 
        catch (InputMismatchException e) {
            e.getStackTrace();
            System.out.println("A Mismatch exception occurred: ");;
        }
        catch (Exception e) {
            e.getStackTrace();
            System.out.println("An exception occurred: ");;
        }
    }
}
