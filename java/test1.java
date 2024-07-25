//unchecked runtime
//checked exception is compile time exception
public class test1 {
   
    public static void main(String[] args) {
        // int a=5,b=0;
        // System.out.println("Before exception ");
        // // System.out.println(c);
        // try {
        //     int c=a/b; 
        // } 
        // catch (Exception e) 
        // {
        //         // System.out.println("During exception handling of current object "+ e);
        //         // System.out.println("During exception handling of current object 1 "+ e.toString());
        //         // System.out.println("During exception handling of current object 2 "+ e.getMessage());
        //        e.printStackTrace();              
        // }
        // System.out.println("After the exception ");


        //---------------------------------------------------------------
        // String s="Charusat";
        // System.out.println(s.charAt(9));
        // int a[]={10,12,13};
        // System.out.println(a[3]);
        // String str=null;
        // System.out.println(str.length());

        // try {
        //         System.out.println(a[3]);
        // }
        // catch(Exception e){
        //             e.getStackTrace();
        // }
        // try {
        //     System.out.println(s.charAt(9));
        // }
        // catch (Exception r) 
        // {
        //     r.getStackTrace();
        // }
        // try{
        //     System.out.println(str.length());
        // }
        // catch(Exception r)
        // {
        //     r.getStackTrace();
        // }


        //-----------------------------------------------------------------
        // int a[]={1,2,3,4};
        // try {
        //     System.out.println(a[5]);
        // } 
        // catch(ArrayIndexOutOfBoundsException arr)
        // {
        //     System.out.println("print out of bound");
        // }
        // catch (Exception e) 
        // {
        //     System.out.println("hi");
        // }


        //------------------------------------------------------------
        //for only one error in try block
        int a[]={1,2,3,4};
        String s="charusat";
        try {
            System.out.println(a[5]);
            System.out.println(s.charAt(15));
        } 
        catch(ArrayIndexOutOfBoundsException arr)
        {
            System.out.println("print out of bound");
        }
        catch(StringIndexOutOfBoundsException e)
        {
            System.out.println("print string index out of bound");
        }
        catch(NullPointerException e)
        {
            System.out.println("print null pointer exception");
        }
        catch (Exception e) 
        {
            System.out.println("hi");
        }
        
       


    }
}
