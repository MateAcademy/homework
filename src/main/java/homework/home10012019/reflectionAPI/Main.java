package homework.home10012019.reflectionAPI;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        try {
            Class c = Class.forName("homework.home10012019.reflectionAPI.Animal");
            Constructor cons[] = c.getDeclaredConstructors();
            for (Constructor constructor : cons) System.out.println(constructor);
            cons[1].setAccessible(true);
            cons[1].newInstance(null);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}