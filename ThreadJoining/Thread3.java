package ThreadJoining;

public class Thread3 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <=101; i++) {
            System.out.printf( "%d@ ", i);

        }
        System.out.println("\n Thread3  completed");
    }
    }
