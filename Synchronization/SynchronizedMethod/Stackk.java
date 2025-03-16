//Question--How can we make entire method() synchronized?
//Ans--By applying synchronized on the method() itself...
package Synchronization.SynchronizedMethod;
//STACK --->LIFO Concepts
public class Stackk {
    //1> Attributes
    private int[]array; //stack storage
    private int stackTopIndex;

    //2>Constructor with argument as capacity of a particular stack
    public Stackk(int capacity){
        array=new int[capacity]; //OBJECT FOR ARRAY...
        stackTopIndex=-1; //No element in the stack initially
    }

    //3>Methods()
    //--1 check if stackk is empty
    public boolean isEmpty(){
        return stackTopIndex<0;
    }
    //3.2>check if stackk is full
    public boolean isFull(){
        return stackTopIndex>=array.length-1;
    }

    //3.3> PUSH()-INSERT ELEMENT INTO STACKK
    public synchronized boolean push(int element) {
        if (isFull()) {
            return false; // Stack is full, cannot insert
        }
        ++stackTopIndex; // Increment stack top index
        try {
            Thread.sleep(1000); // Simulate delay (optional)
        } catch (Exception e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
        array[stackTopIndex] = element; // Insert element into stack
        return true; // Push successful
    }

    //3.4> POP()-REMOVE FROM THE STACK
    public synchronized int pop() {
        synchronized (this){
            if (isEmpty()) {
                return Integer.MIN_VALUE; // Stack underflow case
            }
            int obj = array[stackTopIndex]; // Store the top element
            try {
                Thread.sleep(1000); // Simulate delay (optional)
            } catch (Exception e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
            stackTopIndex--; // Correctly decrement stack pointer
            return obj; // Return popped element
        }
}
}
//CREATE CLASS THREADTESTER
class ThreadTester{
    public static void main(String[] args) {
        System.out.println("Main is starting");
        //object for class Stack
        Stackk stack = new Stackk(5);
        new Thread(()->{
            int counter=0;
            while(++ counter<10)
                System.out.println("Pushed: "+ stack.push(100));
        },"pusher").start();

        new Thread(()->{
            int counter=0;
            while(++ counter<10)
                System.out.println("Popped: "+ stack.pop());
        },"popper").start();
        System.out.println("Main is exiting");
    }
}

