package homework.home7static;

/**
 * @class made Sergey Klunniy, in this class synchronized static method.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        Resourse.i = 5;

        MyThread myThread = new MyThread();
        myThread.setName("one");
        MyThread myThread2 = new MyThread();


        myThread.start();
        myThread2.start();

        myThread.join();
        myThread2.join();

        System.out.println(Resourse.i);

    }
}


class MyThread extends Thread {
    Resourse resourse;

    public void setResourse(Resourse resourse) {
        this.resourse = resourse;
    }

    @Override
    public void run() {
        Resourse.changeStaticI();
//        new Resourse().changeI();
    }
}

class Resourse {
    static int i;

    public static void changeStaticI() {
        synchronized (Resourse.class) {
            int i = Resourse.i;
            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();  //stop this thread and this thread become to pull
            }
            i++;
            Resourse.i = i;
        }
    }

//    public synchronized void changeI() {
//
//            int i = this.i;
//            if (Thread.currentThread().getName().equals("one")) {
//                Thread.yield();  //stop this thread and this thread become to pull
//            }
//            i++;
//            Resourse.i = i;
//    }
}