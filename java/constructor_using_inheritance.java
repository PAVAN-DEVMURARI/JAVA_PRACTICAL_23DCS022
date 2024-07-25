class Base {
    int x;
    Base()
    {
        System.out.println("I am a base class constructor ");
    }
    Base(int x)
    {
        System.out.println("I am a base class constructor with the value of x as "+x);
    }
}


class Derived extends Base{
    int x,y;
    Derived()
    {
        //super(0);
        System.out.println("I am a derived class constructor ");
    }
    Derived (int x , int y)
    {
        super(x);
        System.out.println("I am a derived class constructor with the value of y as "+y );
    }
}

public class constructor_using_inheritance {
    public static void main(String[] args) {
        Derived d=new Derived(5,10);
    }
}
