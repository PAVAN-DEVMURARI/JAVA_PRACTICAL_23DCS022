
class HelloWorldThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello World");
    }
}

public class practical_32_2 {
    public static void main(String[] args) {
        HelloWorldThread thread = new HelloWorldThread();
        thread.start();
    }
}
