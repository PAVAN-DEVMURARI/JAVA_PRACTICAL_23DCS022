public class practical33 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java SumWithThreads <N> <number of threads>");
            return;
        }

        int N = Integer.parseInt(args[0]);
        int numThreads = Integer.parseInt(args[1]);

        int[] partialSums = new int[numThreads];

        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int start = i * (N / numThreads) + 1;
            int end = (i + 1) * (N / numThreads);
            if (i == numThreads - 1) {
                end = N; 
            }
            threads[i] = new Thread(new SumTask(start, end, partialSums, i));
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int finalSum = 0;
        for (int sum : partialSums) {
            finalSum += sum;
        }

        System.out.println("The sum of the first " + N + " numbers is: " + finalSum);
    }
}

class SumTask implements Runnable {
    private int start;
    private int end;
    private int[] partialSums;
    private int index;

    public SumTask(int start, int end, int[] partialSums, int index) {
        this.start = start;
        this.end = end;
        this.partialSums = partialSums;
        this.index = index;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        partialSums[index] = sum;
    }
}
