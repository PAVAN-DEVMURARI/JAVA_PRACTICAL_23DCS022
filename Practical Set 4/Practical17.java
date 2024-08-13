class Parent{
    void say1()
    {
        System.out.println("This is a parent class");
    }
}
class Child extends Parent{
    void say2()
    {
        System.out.println("This a child class");
    }
}
public class Practical17 {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c=new Child();
        p.say1();
        
    }
}
