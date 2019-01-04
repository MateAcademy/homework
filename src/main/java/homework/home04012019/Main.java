package homework.home04012019;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fruite> list = new ArrayList<>();
        list.add(new Fruite(2,  LocalDate.of(2018, 12, 1), 80, Type.STRAWBERRY));
        list.add(new Fruite(30,  LocalDate.of(2018, 12, 01), 16, Type.APPLE ));
        list.add(new Fruite(20,  LocalDate.of(2018, 12, 01), 22, Type.PEAR ));
        list.add(new Fruite(5,  LocalDate.of(2018, 12, 01), 46, Type.CHERRY ));
        list.add(new Fruite(6,  LocalDate.of(2019, 01, 03), 70, Type.GRAPES ));
        list.add(new Fruite(25,  LocalDate.of(2019, 01, 03), 55, Type.CURRANT ));
        list.add(new Fruite(10,  LocalDate.of(2019, 01, 03), 90, Type.PEACH ));
        list.add(new Fruite(10,  LocalDate.of(2019, 01, 03), 90, Type.PEACH ));


        FeaturesOfFruit freshnessOfFruit = new FeaturesOfFruit(list);
        List<Type> freshFruitTypes = freshnessOfFruit.getFreshFruitTypes(LocalDate.now());

        for (int i = 0; i < freshFruitTypes.size(); i++) {
            System.out.println(freshFruitTypes.get(i));
        }

        Type type = Type.PEACH;
        System.out.println("List fruits type of " + type);
        List<Integer> freshFruitTypes2 = freshnessOfFruit.getFreshFruitTypes2(type);

        for (int i = 0; i < freshFruitTypes2.size(); i++) {
            System.out.println(i + ")\t" +freshFruitTypes2.get(i));
        }

        LocalDate date = LocalDate.now();
        System.out.println("List fresh fruits relaetive of date " + date);
        List<Integer> freshFruits = freshnessOfFruit.getFreshFruits(date);

        for (int i = 0; i < freshFruits.size(); i++) {
            System.out.println(i + ")\t" + freshFruits.get(i));
        }


        Integer shelfLife = 20;
        System.out.println("List fresh fruits more than" + shelfLife);

        /*List<Integer>*/ freshFruits = freshnessOfFruit.getFreshFruitTypes3(shelfLife);
        for (int i = 0; i < freshFruits.size(); i++) {
            System.out.println(i + ")\t" + freshFruits.get(i));

            System.out.println();
            Type type2 = Type.PEACH;
            System.out.println("List fruits type of " + type2 +  " which are freash:");
            List<Type> freshFruitTypesDate = freshnessOfFruit.getFreshFruitTypesDate(date, type2);
            for (int p = 0; p < freshFruitTypesDate.size(); p++) {
                System.out.println(p + ")\t" +freshFruitTypes2.get(p));
            }
        }

        Type type1 = Type.PEACH;
        System.out.println(type1.getTranslations());

    }


}
