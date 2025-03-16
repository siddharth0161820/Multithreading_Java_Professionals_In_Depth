package Interview;

public class EvenOddPrinterTesting {
            private int number = 1;  // Start from 1
            private final int limit; // Define the max number to print
            private final Object lock = new Object(); // Shared object for synchronization
            //constructor
            public EvenOddPrinterTesting(int limit) {
                this.limit = limit;
            }

            public void printOdd() {
                synchronized (lock) {
                    while (number < limit) {
                        while (number % 2 == 0) { // If number is even, wait
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("Odd: " + number);
                        number++;  // Increment for even thread
                        lock.notify(); // Wake up even thread
                    }
                }
            }

            public void printEven() {
                synchronized (lock) {
                    while (number < limit) {
                        while (number % 2 != 0) { // If number is odd, wait
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("Even: " + number);
                        number++;  // Increment for odd thread
                        lock.notify(); // Wake up odd thread
                    }
                }
            }
        }

 class EvenOddThreads {
    public static void main(String[] args) {
        System.out.println("Main thread started");

        EvenOddPrinterTesting printer = new EvenOddPrinterTesting(12); // Print up to 11

        Thread oddThread = new Thread(() -> printer.printOdd());
        Thread evenThread = new Thread(() -> printer.printEven());

        oddThread.start();
        evenThread.start();

        System.out.println("Main thread exiting");
    }
}


/////////////////////////////////////////////////////////////////////////////////////
//print code to work with 5 threads printing data one by one
class OrderedPrintingSimple {
    private static int turn = 1;  // Start with Thread-1
    private static final Object lock = new Object();

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            final int threadId = i;
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {  // Each thread prints 5 times
                    synchronized (lock) {
                        while (turn != threadId) {  // Wait for its turn
                            try { lock.wait(); } catch (InterruptedException e) {}
                        }
                        System.out.println("Thread-" + threadId + " printing");
                        turn = (turn % 5) + 1;  // Move to next thread
                        lock.notifyAll();  // Wake up other threads
                    }
                }
            }).start();
        }
    }
}
