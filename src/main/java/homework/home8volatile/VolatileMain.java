package  homework.home8volatile;

public class VolatileMain {
    volatile static int i = 0;

    public static void main(String[] args) {

        new MyThreadRead().start();
        new MyThreadWrite().start();
    }

    static class MyThreadWrite extends Thread {
        @Override
        public void run() {
            while (i < 5) {
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadRead extends Thread {
        @Override
        public void run() {
            int localVare = i;
            while (localVare < 5) {
                if (localVare != i) {
                    System.out.println("new value of i is " + i);
                    localVare = i;
                }
            }
        }
    }
}
