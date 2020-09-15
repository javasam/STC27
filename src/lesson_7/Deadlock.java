package lesson_7;

public class Deadlock {
    final static Object lock1 = new Object();
    final static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();

    }

    private static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                    System.out.println("Block monitor 1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    try {
                        Thread.sleep(100);
                        System.out.println("Block monitor 2");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class Thread2 extends Thread {

        @Override
        public void run() {
            synchronized (lock2) {
                try {
                    Thread.sleep(100);
                    System.out.println("Block monitor 2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    try {
                        Thread.sleep(100);
                        System.out.println("Block monitor 1");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
