class Shape{
    void printShape(){
        System.out.println("This is shape");
    }
}

class Rectangle extends Shape{
    void printRectangle(){
        System.out.println("This is rectangular shape");
    }
}

class Square extends Rectangle{
    void printSquare(){
        System.out.println("Square is a rectangle");
    }
}

class Circle extends Shape{
    void printCircle(){
        System.out.println("This is circular shape");
    }
}

public class Practical_20 {
    public static void main(String[] args) {
        Square s = new Square();
        s.printShape();
        s.printRectangle();
        System.out.println("Name: Pavan Devmurari\nID: 23DCS022");
    }
}