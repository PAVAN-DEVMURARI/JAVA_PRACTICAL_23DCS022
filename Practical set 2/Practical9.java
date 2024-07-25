import java.util.Scanner;

public class Practical9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string ");
        String s=sc.nextLine();
        String str;
        System.out.println("Displaying the string ");
        for (int i=0;i<s.length();i++)
        {
            System.out.print(s.charAt(i)+""+s.charAt(i));
//                str=s.charAt(i)+s.charAt(i);
        }
    }
}
