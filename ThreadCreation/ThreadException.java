package ThreadCreation;

import java.lang.Thread;

/**
 * ThreadException
 */
public class ThreadException {
    public static void main(String[] args) throws RuntimeException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run()  {
                System.out.println("We are in thread: " + Thread.currentThread().getName());
                throw new RuntimeException("Intentional Exception");
            }
        });

        thread.setName("Missbehaving Thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(String.format("A critical error happened in thread %s: %s", t.getName(), e.getMessage()));
            }
        });
        thread.start();
    }
}
