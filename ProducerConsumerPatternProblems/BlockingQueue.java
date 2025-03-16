package ProducerConsumerPatternProblems;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    //1> Create a queue
    private Queue<Integer>q; //reference of Queue
    private int capacity;

    //2>Constructor
    public BlockingQueue(int cap){
        q = new LinkedList<>();
        capacity= cap;
    }

    //3> Implement two methods()
     //3.1> Add()
    public boolean add(int item){
        //since multiple threads are trying to access so to avoid race condition use synchronized block with explicit lock
        synchronized (q){
             while (q.size()==capacity){
                 try {
                     q.wait();//adder1, adder2
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
             }
                 q.add(item);
                 q.notifyAll();
             }
        return true;
    }

    //3.2> remove()
    public int remove(){
        synchronized (q){
            while (q.size()==0){//no items addedd...
                try {
                    q.wait();//this queue says we need to wait(so that other threads gets a chance for execution) till condition
                    // gets true items availability..this wait() throws an uninterepted exceptions
                    //now notify() will inform queue is available
                    //whichever threads add items need to notify
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
                int element = q.poll();
            q.notifyAll();
            return element;

        }

    }
}

//For remove()
//here no items available so nothing to omit and all other
// threads are restricted as bounded by same lock
///so this methods()need to wait until any items addedd to it for performing omiting....
//object class is parent of all classes and do have two methods in-built
//wait(),notify(),notifyall()
//therefore,queue also extends object class

//notify()--means notify a particular(single) threads
//notifyAll()---notify all th threads

////////////////////////////
//add()
//1> if for some reason queue is full thread needs to wait
//2> allow wait() relinquishes the lock so that other thread can execute the methods
//3> but still queue full 2 threads waiting in a queue to excute and get out of critical section
//adder1, adder 2 threads waiting at wait set for their turns..
//4> 1 item removed notifyall() done waiting thread starts excution but more waiting in waiitng set to gets executed
//5> better use while loop..
