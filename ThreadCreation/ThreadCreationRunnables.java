package ThreadCreation;
/**
 * ThreadCreation
 */
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

// Thread Creation - Multi Executor
public class ThreadCreationRunnables {

    public static void main(String[] args) throws InterruptedException {
        List<Runnable> listOfRunnables = new ArrayList<Runnable>() {
            {
                add(new Runnable() {
                    public void run() {
                        System.out.println("I am Worker Thread 1 of name " + Thread.currentThread().getName() + " and id of " + Thread.currentThread().threadId());
                    }
                });
                add(new Runnable() {
                    public void run() {
                        System.out.println("I am Worker Thread 2 of name " + Thread.currentThread().getName() + " and id of " + Thread.currentThread().threadId());
                    }
                });
                add(new Runnable() {
                    public void run() {
                        System.out.println("I am Worker Thread 3 of name " + Thread.currentThread().getName() + " and id of " + Thread.currentThread().threadId());
                    }
                });
            }
        };

        for(Runnable r : listOfRunnables) {
            Thread newThread = new Thread(r);
            System.out.println("We are in thread: " + Thread.currentThread().getName() + " of id " + Thread.currentThread().threadId() + " before starting a new thread.");
            newThread.start();
            System.out.println("We are in thread: " + Thread.currentThread().getName() + " of id " + Thread.currentThread().threadId() + " after starting a new thread.");
            Thread.sleep(1000);
        }
    }
}