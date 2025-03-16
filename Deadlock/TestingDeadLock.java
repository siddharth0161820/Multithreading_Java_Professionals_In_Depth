package Deadlock;

public class TestingDeadLock {
    public static void main(String[] args) {
        long startThreadTime=System.currentTimeMillis();
        System.out.println(startThreadTime);
        System.out.println("Main Thread is starting");
   //1> Create objects for the 2 locks
        String lock1 = "Sidd";
        String lock2 = "Kumar";


        //2>thread creation using java 8 lambda function
        Thread thread1 = new Thread(() -> {
         synchronized(lock1){
             System.out.println("thread1 acquired lock2");
             try {
                 System.out.println("thread1 sleeping for 3 sec");
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             System.out.println("thread1 woke up");
             synchronized (lock2){ //hold and wait as one thread siddharth tries to hold one more key occurs deadlock
                 System.out.println("lock2 got his key");
             }
         }
        });

        Thread thread2 = new Thread(() -> {
            synchronized(lock2){
                System.out.println("thread2 acquired lock1");
                try {
                    System.out.println("thread1 sleeping for 3 sec");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread2 woke up");
                synchronized (lock1){ //hold and wait as one thread siddharth tries to hold one more key occurs deadlock
                    System.out.println("lock1 got his key");
                }
            }
        });
        //3>starting the threads
        thread1.start();
        thread2.start();
        System.out.println("Main thread exiting");
        long endThreadTime=System.currentTimeMillis();
        System.out.println(endThreadTime);
        System.out.println("Total time taken for thread execution: "+(endThreadTime-startThreadTime));
    }

}
//note:program will never terminate as program went into deadlck situation

