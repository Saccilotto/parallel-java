/**
 * ThreadCreation
 */
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

// Thread Creation - Multi Executor
public class ThreadCreation {

    public static void main(String[] args) {
        List<Runnable> listOfRunnables = new ArrayList<Runnable>() {
            {
                add(new Runnable() {
                    public void run() {
                        System.out.println("I am Thread 1");
                    }
                });
                add(new Runnable() {
                    public void run() {
                        System.out.println("I am Thread 2");
                    }
                });
                add(new Runnable() {
                    public void run() {
                        System.out.println("I am Thread 3");
                    }
                });
            }
        };

        for(Runnable r : listOfRunnables) {
            Thread newThread = new Thread(r);
            newThread.start();
        }
    }
}