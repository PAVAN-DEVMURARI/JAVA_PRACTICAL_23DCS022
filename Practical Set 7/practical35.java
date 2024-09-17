public class practical35 {
    
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int value = 0;  

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println("Thread was interrupted: " + e.getMessage());
                }

                value++;

                System.out.println("Value after 1 second: " + value);
            }
        });

        thread.start();
    }
}
