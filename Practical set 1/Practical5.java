import java.util.Scanner;

public class Practical5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the product code (1 for motor, 2 for fan, 3 for tube, 4 for wires):");
        int productCode = sc.nextInt();


        System.out.println("Enter the quantity:");
        int quantity = sc.nextInt();


        double price;
        switch (productCode) {
            case 1:
                price = 100.0; // Motor price
                break;
            case 2:
                price = 80.0; // Fan price
                break;
            case 3:
                price = 50.0; // Tube light price
                break;
            case 4:
                price = 30.0; // Wires price
                break;
            default:
                price = 0.0; // Other items (code 5 or more)
        }


        double salesTax;
        switch (productCode) {
            case 1:
                salesTax = 0.08; // 8% for motor
                break;
            case 2:
                salesTax = 0.12; // 12% for fan
                break;
            case 3:
                salesTax = 0.05; // 5% for tube light
                break;
            case 4:
                salesTax = 0.075; // 7.5% for wires
                break;
            default:
                salesTax = 0.03; // 3% for other items
        }


        double totalPrice = price * quantity + (price * quantity * salesTax);

        System.out.println("Product code: " + productCode);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price per item: Ruppess" + price);
        System.out.println("Sales tax rate: " + (salesTax * 100) + "%");
        System.out.println("Total price (including tax): Ruppess" + totalPrice);

        sc.close();
    }
}
