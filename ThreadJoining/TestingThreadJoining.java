package ThreadJoining;

public class TestingThreadJoining {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starting");
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();
        thread1.start();
        System.out.println("\n thread 1 started");
        thread2.start();
        System.out.println("\n thread 2 started");
        thread1.join();
        thread3.start();
        System.out.println("\n thread 3 started");
        System.out.println("Main thread exiting");
    }
}
