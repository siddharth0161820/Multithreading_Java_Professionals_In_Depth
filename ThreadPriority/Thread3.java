package ThreadPriority;

public class Thread3  extends Thread {
    //constructor
    public Thread3(String threadname) {
        super(threadname);
    }

    //run()
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside thread3  " + Thread.currentThread().getName() + " " + i);

            //System.out.println("Inside  "+ Thread.currentThread() + " "+ i);
        }
    }
}
