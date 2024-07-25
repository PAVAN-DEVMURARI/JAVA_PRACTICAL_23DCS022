import java.util.Scanner;

public class Practical6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of days (n): ");
        int n = sc.nextInt();


        int term1 = 0;
        int term2 = 1;

        System.out.println("Exercise durations for " + n + " days:");


        for (int i = 0; i < n; i++) {
            System.out.print(term1 + " ");
            int nextTerm = term1 + term2;
            term1 = term2;
            term2 = nextTerm;
        }


    }
}
