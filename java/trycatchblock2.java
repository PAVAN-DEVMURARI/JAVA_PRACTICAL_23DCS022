public class trycatchblock2 {
    public static void main(String[] args) {
        
        int[] a = {1, 2, 3, 4};
        String s = "charusat";
        try {
            // Attempt to access an invalid array index
            try {
                System.out.println(a[5]);
            } catch(ArrayIndexOutOfBoundsException arr) {
                System.out.println("Array index out of bound");
            }
            
            // Attempt to access an invalid string index
            try {
                System.out.println(s.charAt(15));
            } catch(StringIndexOutOfBoundsException e) {
                System.out.println("String index out of bound");
            }
            
            // This block is not needed for the given operations
            // as they do not throw ArithmeticException
            // try {
            //     // Code that might throw ArithmeticException
            // } catch(ArithmeticException e) {
            //     System.out.println("Arithmetic exception");
            // }
           
        } catch(Exception e) {
            // This catch block will catch any other Exception not caught by inner catch blocks
            System.out.println("An unexpected exception occurred: " + e.getMessage());
        }
    }
}