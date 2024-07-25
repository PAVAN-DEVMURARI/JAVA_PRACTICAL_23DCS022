import java.util.Scanner;

public class Practical4 {
    public static void main(String[] args) {
        System.out.println("Enter the number of employees ");
        Scanner sc= new Scanner(System.in);
        int target=sc.nextInt();
        int sum=0;
        int []expenses=new int[target];
        for (int i=0;i<target;i++)
        {
            expenses[i]=sc.nextInt();
            sum = sum +expenses[i];

        }
        System.out.println("The total expense is "+sum);
    }
}
