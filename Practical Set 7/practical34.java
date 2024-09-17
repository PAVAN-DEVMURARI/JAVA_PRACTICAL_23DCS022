import java.util.Random;

class RandomNumberGenerator extends Thread {
    public void run() {
        Random random = new Random();
        while (true) {
            int number = random.nextInt(10) + 1;
            System.out.println("Generated Number: " + number);
            if (number % 2 == 0) {
                new SquareCalculator(number).start();
            } else {
                new CubeCalculator(number).start();
            }
            try {
                Thread.sleep(1000); // Wait for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class SquareCalculator extends Thread {
    private int number;

    SquareCalculator(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Square of " + number + " is: " + (number * number));
    }
}

class CubeCalculator extends Thread {
    private int number;

    CubeCalculator(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Cube of " + number + " is: " + (number * number * number));
    }
}

public class practical34 {
    public static void main(String[] args) {
        new RandomNumberGenerator().start();
    }
}
