import java.util.Scanner;

public class Practical3 {
    public static void main(String[] args) {

        System.out.println("Taking Input");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter distance in km");
        float distance=sc.nextFloat();
        System.out.println("Enter time taken in hours");
        float time_in_hrs=sc.nextFloat();
        System.out.println("Enter time taken in minutes");
        float time_in_min=sc.nextFloat();
        System.out.println("Enter time taken in seconds");
        float time_in_sec=sc.nextFloat();
        System.out.println("Displaying speed in m/s");
        float speed = (distance*1000f/(time_in_hrs*3600f)+(time_in_min*60f)+time_in_sec);
        System.out.println("The speed is "+ speed + " m/s");
        System.out.println("Displaying speed in km/h");
        float speed2 = (distance/(time_in_hrs)+(time_in_min*1/60f)+time_in_sec*1/3600f);
        System.out.println("The speed is "+ speed2 + " km/h");
        System.out.println("Displaying speed in miles/s");
        float speed3 = (distance*(1609/1000f)/(time_in_hrs*3600f)+(time_in_min*60f)+time_in_sec);
        System.out.println("The speed is "+ speed3 + " miles/s");

    }
}
