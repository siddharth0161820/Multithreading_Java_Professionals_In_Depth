package ThreadPriority;

import ThreadCreation.ExtendsTheThread.Thread1;

public class TestingThreadPriority {
        public static void main(String[] args) {
            long startTime = System.currentTimeMillis();
            System.out.println("Time to start thread: "+startTime);
            System.out.println("Main is starting");
            //Create Object for the Class Thread 1
            Thread thread1 = new Thread1("thread1");

            //Create Object for the Class Thread 2
            Thread thread2 = new Thread1("thread2");

            //Create Object for the Class Thread 3
            Thread thread3 = new Thread1("thread3");

             thread1.setDaemon(true); //now thread 1 became daemon thread
            thread2.setDaemon(true); //now thread 1 became daemon thread
            //thread1.setPriority(Thread.MAX_PRIORITY);
            thread1.start();
           // thread2.setPriority(Thread.MIN_PRIORITY);
            thread2.start();
           // thread3.setPriority(Thread.NORM_PRIORITY);
            thread3.start();

            System.out.println("Main is exiting");
            long endTime = System.currentTimeMillis();
            System.out.println("Time to endthread: "+endTime);
            System.out.println("Total time to execute the thread is: "+(endTime-startTime));
        }
    }

//thread priority doesnt guarantee order of execution....