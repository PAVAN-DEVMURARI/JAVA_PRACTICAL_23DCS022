import java.util.Scanner;
 class Employee {

    String fname;
    String lname;
    Double Sal;
    Scanner S1=new Scanner(System.in);

    void getfs()
    {
        fname=S1.nextLine();
    }
    void getls()
    {
        lname=S1.nextLine();
    }
    void getsal()
    {
        Sal=S1.nextDouble();
if(Sal<0)
{
Sal=0.0;
}
else
{
Sal=Sal+(10/100);
}

    }
    Employee()
    {

}


    Employee(String fs,String ls,double sl)
    {
        fname = fs;
        lname = ls;
        Sal = sl;
    }
    void putfs()
    {
        System.out.println(""+fname);
    }
    void putls()
    {
        System.out.println(""+lname);

    }
    void putsal()
    {
    System.out.println(""+Sal);
    }
};

public class Practical13
{
    
    public static void main(String[] args)
    {
        Employee E1,E2;
        E1.getls();
        E1.getls();
        E1.getls();
        
	
        
    }
}
