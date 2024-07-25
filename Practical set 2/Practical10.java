import java.util.Arrays;
import java.util.Scanner;

public class Practical10
{
    public static void main(String[] args) {
        String st,str;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string ");
        st=sc.nextLine();
        System.out.println(st.length());
        System.out.println(st.toLowerCase());
        System.out.println(st.toUpperCase());
        char[] reversedArray = new char[st.length()];
        for (int i = st.length() - 1; i >= 0; i--) {
            reversedArray[st.length() - i - 1] = st.charAt(i);
        }

        for (int i=0;i<st.length();i++)
        {
            System.out.print(reversedArray[i]+"");
        }
        System.out.println();
         Arrays.sort(reversedArray);
        for (int i=0;i<st.length();i++)
        {
            System.out.print(reversedArray[i]+"");
        }
    }

}


