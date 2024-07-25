import java.util.Scanner;

public class Complex {

    private double real;
    private double imaginary;

    // Empty constructor
    public Complex() {
    }

    // Constructor to initialize real and imaginary parts
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Method to get user input for real and imaginary parts
    public static Complex getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter real part: ");
        double real = scanner.nextDouble();
        System.out.print("Enter imaginary part: ");
        double imaginary = scanner.nextDouble();
        return new Complex(real, imaginary);
    }

    // Method to add two complex numbers
    public Complex add(Complex other) {
        return new Complex(real + other.real, imaginary + other.imaginary);
    }

    // Method to subtract two complex numbers
    public Complex subtract(Complex other) {
        return new Complex(real - other.real, imaginary - other.imaginary);
    }

    // Method to multiply two complex numbers
    public Complex multiply(Complex other) {
        double newReal = (real * other.real) - (imaginary * other.imaginary);
        double newImaginary = (real * other.imaginary) + (imaginary * other.real);
        return new Complex(newReal, newImaginary);
    }

    // Method to print the complex number in a+bi format
    @Override
    public String toString() {
        return String.format("%.2f + %.2fi", real, imaginary);
    }

    public static void main(String[] args) {
        System.out.println("Enter first complex number:");
        Complex number1 = getInput();
        System.out.println("Enter second complex number:");
        Complex number2 = getInput();

        // Perform operations
        Complex sum = number1.add(number2);
        Complex difference = number1.subtract(number2);
        Complex product = number1.multiply(number2);

        // Print results
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
    }
}
