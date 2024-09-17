public class practical36 {

    public static void main(String[] args) {
        // Create thread instances
        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread FIRST is running with priority: " + Thread.currentThread().getPriority());
            }
        }, "FIRST");

        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread SECOND is running with priority: " + Thread.currentThread().getPriority());
            }
        }, "SECOND");

        Thread thirdThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread THIRD is running with priority: " + Thread.currentThread().getPriority());
            }
        }, "THIRD");

       
        firstThread.setPriority(3);  
        secondThread.setPriority(Thread.NORM_PRIORITY);  
        thirdThread.setPriority(7); 

       
        firstThread.start();
        secondThread.start();
        thirdThread.start();
    }
}
