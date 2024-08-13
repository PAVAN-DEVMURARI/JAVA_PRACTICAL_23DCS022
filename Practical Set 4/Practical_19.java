class rectangle{
    public int length;
    public int breadth;
    rectangle(int l,int b)
    {
        length=l;
        breadth=b;  
    }
    void print_area()
    {
        System.out.println("Area of rectangle is: "+length*breadth);
    }
    void print_perimeter()
    {
        System.out.println("Perimeter of rectangle is: "+2*(length+breadth));
    }
}
class square extends rectangle{
    square(int s)
    {
        super(s,s);
    }
    void print_area1()
    {
        System.out.println("Area of square is: "+length*breadth);
    }
    void print_perimeter1()
    {
        System.out.println("Perimeter of square is: "+2*(length+breadth));
    }
}
public class Practical_19 {
    public static void main(String[] args) {
        // rectangle r = new rectangle(5, 10);
        square s = new square(5);
        // r.print_area();
        // r.print_perimeter();
        // s.print_area();
        // s.print_perimeter();
        s.print_area();
        s.print_perimeter();

    }
}
