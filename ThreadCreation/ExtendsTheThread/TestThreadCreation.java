package ThreadCreation.ExtendsTheThread;

public class TestThreadCreation {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Time to start thread: "+startTime);
        System.out.println("Main is starting");
     //Create Object for the Class Thread 1
        Thread thread1 = new Thread1("thread1");
        // thread1.setDaemon(true); //now thread 1 became daemon thread
        thread1.start();
        System.out.println("Main is exiting");
        long endTime = System.currentTimeMillis();
        System.out.println("Time to endthread: "+endTime);
        System.out.println("Total time to execute the thread is: "+(endTime-startTime));
    }
}




//start()--it informs jvm that user is ready to start the thread whenever jvm feel free will start the excution..
//Here two threads will be running
     //1> by default main thread is running
    //2> child of main thread custom thread i.e..thread1(as thread1 created frm main thread)
    //3>No order maintained for executing...depends on jvm in which order it excutes the code

    //4>main thread is a user thread
    //5> IMPORTANT POINTS--if jvm finds no user thread running then jvm might
//       not allow the daemon thread(thread1 if we setDaemon(true)) to gets executed.
       //5.1> But if the jvm finds any user thread apart frm main thread running it will continue running
             //until all the user threads  finishes its job or gets executed
