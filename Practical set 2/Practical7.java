
import java.util.Scanner;

public class Practical7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many times you want to print the substring ");
        int n=sc.nextInt();
        System.out.println("Enter the string ");
        String s=sc.next();
        String str=s.substring(0,3);
        for (int i=0;i<n;i++)
        {
            System.out.print(str+" ");
        }


    }
}
