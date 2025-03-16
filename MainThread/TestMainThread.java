package MainThread;
public class TestMainThread {
    public static void main(String[] args) {
        System.out.println("Hello!!");
        System.out.println("Printing the main thread which starts running(automatically) as the program starts running:  "
                +Thread.currentThread().getName());
        System.out.println("Thanks");
    }
}
