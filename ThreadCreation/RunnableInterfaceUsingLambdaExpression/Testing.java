package ThreadCreation.RunnableInterfaceUsingLambdaExpression;

public class Testing {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Time to start thread: "+startTime);
        System.out.println("Main is starting");
        //Create Object for the Class Thread 2
        Thread thread2 = new Thread(()->
        {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread()+" "+ i);

            }
        },"thread2"); //(object for thread2 ,thread2 name)
        thread2.start();
        System.out.println("Main is exiting");
        long endTime = System.currentTimeMillis();
        System.out.println("Time to endthread: "+endTime);
        System.out.println("Total time to execute the thread is: "+(endTime-startTime));
    }
}
