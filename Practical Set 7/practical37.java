class practical37 {
    private final int[] buffer;
    private int count = 0;
    private final int capacity;

    public practical37(int size) {
        buffer = new int[size];
        capacity = size;
    }

   
    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (count == capacity) {
                    wait();
                }
                
                buffer[count] = value;
                System.out.println("Produced: " + value);
                value++;
                count++;

                notify();
            }
            Thread.sleep(500);
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (count == 0) {
                    wait();
                }

                int value = buffer[count - 1];
                System.out.println("Consumed: " + value);
                count--;

                notify();
            }
            Thread.sleep(500);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        practical37 pc = new practical37(5); // buffer size = 5

        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}