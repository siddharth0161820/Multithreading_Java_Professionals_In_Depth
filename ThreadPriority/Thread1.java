package ThreadPriority;

public class Thread1 extends Thread{
    //constructor overloading
    public Thread1(String threadname){
     super(threadname);
    }
    @Override
    public void run() {
        for (int i = 0; i <5 ; i++) {
            System.out.println("Inside thread1  "+ Thread.currentThread().getName() + " "+i);

            //System.out.println("Inside  "+ Thread.currentThread() + " "+ i);
        }
    }
}
