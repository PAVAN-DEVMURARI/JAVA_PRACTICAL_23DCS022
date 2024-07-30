import java.util.Scanner;

class Area {
    double length;
    double breadth;

   
    Area(double l, double b) {
        length = l;
        breadth = b;
    }

    
     double returnArea() {
        return length * breadth;
    }
}

class Practical15 {
    public static void main(String[] args) 
{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length:");
        double length = scanner.nextDouble();
        System.out.println("Enter breadth:");
        double breadth = scanner.nextDouble();

        Area A = new Area(length, breadth);



        System.out.println(A.returnArea());

    }
}