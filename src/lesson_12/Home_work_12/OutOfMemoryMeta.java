package lesson_12.Home_work_12;

/**
 * A simple class that creates a potential memory leak, but you need to wait a long time
 */

public class OutOfMemoryMeta extends Thread {

    public void run() {
        while (true) {
            new OutOfMemoryMeta();
        }
    }
}
