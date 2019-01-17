package homework;
import java.util.concurrent.Callable;
/**
 * Экзекюторы.
 */
public class CountThread implements Callable<String> {

    private CommonResourse res;

    private String name;

    public CountThread(CommonResourse res, String name) {
        this.res = res;
        this.name = name;
    }




    @Override
    public String call() throws Exception {
        System.out.println(name + "waiting");


        try {
            for (int i = 0; i < 5; i++) {
                res.incrementValue();
                System.out.println(this.name + ":" + res.getValue());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());


        }return name;
    }
}
