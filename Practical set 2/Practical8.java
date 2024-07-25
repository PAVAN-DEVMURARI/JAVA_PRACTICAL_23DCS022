import java.util.Scanner;

public class Practical8 {
    public static int func(int arr[], int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i]==9)
            {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter the length of an array: ");
        n = sc.nextInt();


        int[] arr = new int[n];


        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int countDuplicates = func(arr, n);


        System.out.println("The 9's repeated are : " + countDuplicates);


        sc.close();
    }
}
