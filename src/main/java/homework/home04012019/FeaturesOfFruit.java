package homework.home04012019;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FeaturesOfFruit {
    private List<Fruite> fruits;

    public FeaturesOfFruit(List<Fruite> list) {
        this.fruits = list;
    }

    public List<Integer> getFreshFruits(LocalDate date) {
        List<Integer> freshFruits = new ArrayList<>();
        for (int i = 0; i < fruits.size(); i++) {
            if (checkTimeOfFruits(fruits.get(i), date)) freshFruits.add(i);
        }
        return freshFruits;
    }

    public List<Type> getFreshFruitTypes(LocalDate date) {
        List<Type> freshFruits = new ArrayList<>();
        for (int i = 0; i < fruits.size(); i++) {
            Fruite element = fruits.get(i);
            if (checkTimeOfFruits(element, date)) freshFruits.add(element.getType());
        }
        return freshFruits;
    }

    public List<Integer> getFreshFruitTypes2(Type type) {
        List<Integer> freshFruits = new ArrayList<>();
        for (int i = 0; i < fruits.size(); i++) {
            Fruite element = fruits.get(i);
            if (element.getType().equals(type)) freshFruits.add(i);
        }
        return freshFruits;
    }

    public List<Integer> getFreshFruitTypes3(Integer shelfLife) {
        List<Integer> freshFruits = new ArrayList<>();
        for (int i = 0; i < fruits.size(); i++) {
            Fruite element = fruits.get(i);
            if (element.getShelfLife()>shelfLife) freshFruits.add(i);
        }
        return freshFruits;
    }

    public List<Type> getFreshFruitTypesDate(LocalDate date, Type type) {
        List<Type> freshFruits = getFreshFruitTypes( date);
        List<Type> freshFruits2 = new ArrayList<>();
        for (int i = 0; i < freshFruits.size(); i++) {
            if (type ==freshFruits.get(i)) freshFruits2.add(freshFruits.get(i));
        }
        return freshFruits2;
    }


    private boolean checkTimeOfFruits(Fruite element, LocalDate date) {
        return element.getDate().plusDays(element.getShelfLife()).compareTo(date) >= 0;
    }
}
