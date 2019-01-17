package homework;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        CommonResourse res = new CommonResourse(3);

        Callable<String> callable1 = new CountThread(res, "Thread1");
        Callable<String> callable2 = new CountThread(res, "Thread2");
        Callable<String> callable3 = new CountThread(res, "Thread3");


        Future<String> future = service.submit(callable1);
        Future<String> future2 = service.submit(callable2);
        Future<String> future3 = service.submit(callable3);



        try {
            future.get();
            future2.get();
            future3.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
