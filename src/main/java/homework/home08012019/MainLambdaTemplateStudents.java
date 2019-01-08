package homework.home08012019;

import static homework.home08012019.Vitamins.*;
import static homework.home08012019.FruitType.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import  static java.util.Arrays.asList;
/**
 * @author Klunniy Sergey
 */
public class MainLambdaTemplateStudents {
	public static void main(String[] args) {
		List<Fruit> fruits = fillFruitsList();

		System.out.println("\nAll collection fruits:");
		fruits.forEach(System.out::println);

		System.out.println("\nFilters records:");
		fruits.stream().filter(fruit -> fruit.getFruitType().equals(PEAR)).forEach(System.out::println);

		System.out.println("\nLets skip 4 elements and other print:");
		fruits.stream().skip(4).forEach(System.out::println);

		System.out.println("\nReturns a stream without duplicates:");
		fruits.stream().distinct().forEach(System.out::println);

		System.out.println("\nConverts every element of stream");
		fruits.stream().map(fruit -> fruit.getFruitType()+ " " + fruit.getPrice()).forEach(System.out::println);

		System.out.println("\nConverts every element of stream and output Name:");
		fruits.stream().map(Fruit::getFruitType).forEach(System.out::println);

		//внутри фрукта создать метод который выводит тип фрукта  и цену:
		System.out.println(("\nOutput name and Price fruit:"));
		fruits.stream().map(Fruit::getPriseAndType).forEach(System.out::println);

		System.out.println("\nReturns the same stream, output name and Price fruit:");
		fruits.stream().peek(System.out::println).map(Fruit::getPriseAndType).forEach(System.out::println);

		System.out.println("\nAllow us to limit 4 first elements: ");
		fruits.stream().limit(4).forEach(System.out::println);

		System.out.println();
		//отсортировать по типу и потом по цене, переопределить компоратор
		Comparator<Fruit> comparator = new Comparator<Fruit>() {
			@Override
			public int compare(Fruit fr1, Fruit fr2) {
				int r = fr1.getFruitType().toString().compareTo(fr2.getFruitType().toString());
				if (r != 0) {
					return r;
				} else {
					return fr1.getPrice() - fr2.getPrice();
				}

			}
		};
		System.out.println("\nSorted for type with comparator:");
		fruits.stream().sorted(comparator).forEach(System.out::println);

		System.out.println("\nConvert to mapToInt Stream Price:");
		int[] prices = fruits.stream().mapToInt(Fruit::getPrice).toArray();
		System.out.println(Arrays.toString(prices));

		System.out.println("\nConvert to mapToDouble Stream Price:");
		double[] prices2 = fruits.stream().mapToDouble((Fruit::getPrice)).toArray();
		System.out.println(Arrays.toString(prices2));

		System.out.println("\nConvert to mapToLong Stream Price:");
		long[] prices3 = fruits.stream().mapToLong((Fruit::getPrice)).toArray();
		System.out.println(Arrays.toString(prices3));

		System.out.println("\nShow vitamins for every fruit");
		fruits.stream().peek(fr -> System.out.println("For " + fr.getFruitType() + " we show "))
				.flatMap(fr -> fr.getVitamins().stream()).forEach(System.out::println);

		Stream.of(asList("one","two"),asList("three", "four")).flatMap(x -> x.stream()) ;

		System.out.println("\nShow all vitamins that present now in fruits:");
		fruits.stream().flatMap(fr -> fr.getVitamins().stream()).distinct().forEach(System.out::println);


		System.out.println("\nFind first in stream:");
		System.out.println(fruits.stream().findFirst().get());

		System.out.println("\nFindAny in stream:");
		System.out.println(fruits.stream().findAny().get().getFruitType());

		System.out.println("\nList of deliveryDates");
		System.out.println(fruits.stream().map(Fruit::getDeliveryDate).collect(Collectors.toList()));

		System.out.println("\nCount ORANGE");
		System.out.println(fruits.stream().filter(fr -> ORANGE.equals(fr.getFruitType())).count());

		System.out.println("\nHave we fruits that can live more 50 days, should be true because we have ORANGE?");
		System.out.println(fruits.stream().anyMatch(fr -> fr.getDayToLive() > 50));

		System.out.println("\nCannot any fruits live more 61 days?");
		System.out.println(fruits.stream().noneMatch(fr -> fr.getDayToLive() > 61));

		System.out.println("\nCan all fruits live more 5 days?");
		System.out.println(fruits.stream().allMatch(fr -> fr.getDayToLive() >= 5));

		System.out.println("\nMinimum time to live is:");
		System.out.println(fruits.stream().map(Fruit::getDayToLive).min(Comparator.naturalOrder()).get());

		System.out.println("\nMaximum time to live is:");
		System.out.println(fruits.stream().map(Fruit::getDayToLive).max(Comparator.naturalOrder()).get());

		System.out.println("\nShow forEach parallel:");
		fruits.parallelStream().forEach(System.out::println);

		System.out.println("\nShow forEachOrdered parallel:");
		fruits.parallelStream().forEachOrdered(System.out::println);

		System.out.println("\nShow array of deliveryDates:");
		LocalDate[] arrayDate = fruits.stream().map(Fruit::getDeliveryDate).toArray(LocalDate[]::new);
		System.out.println(Arrays.toString(arrayDate));

		System.out.println("\nShow border timeToLive(bigger then) and price(less then):");
		Fruit complexFruit = fruits.stream().reduce((fr1, fr2) -> {
			Fruit result = new Fruit(null, -1, null, -1, null);
			result.setPrice(Math.max(fr1.getPrice(), fr2.getPrice()));
			result.setDayToLive(Math.min(fr1.getDayToLive(), fr2.getDayToLive()));
			return result;
		}).get();
		System.out.println(complexFruit);


	}





	private static List<Fruit> fillFruitsList() {
		List<Fruit> fruits = new ArrayList<>();

		Fruit fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
		fruit.setVitamins(Arrays.asList(new Vitamins[] { B, C }));
		fruits.add(fruit);

		fruit = new Fruit(STRAWBERRY, 15, LocalDate.of(2019, 1, 2), 50, null);
		fruit.setVitamins(Arrays.asList(new Vitamins[] { A, C }));
		fruits.add(fruit);

		fruit = new Fruit(PEAR, 30, LocalDate.of(2019, 1, 4), 40, null);
		fruit.setVitamins(Arrays.asList(new Vitamins[] { A, B1, B2, C }));
		fruits.add(fruit);

		fruit = new Fruit(ORANGE, 60, LocalDate.of(2019, 1, 3), 30, null);
		fruit.setVitamins(Arrays.asList(new Vitamins[] { E, B, A }));
		fruits.add(fruit);

		fruit = new Fruit(STRAWBERRY, 25, LocalDate.of(2019, 1, 2), 60, null);
		fruit.setVitamins(Arrays.asList(new Vitamins[] { A, C, D }));
		fruits.add(fruit);

		fruit = new Fruit(PEAR, 15, LocalDate.of(2019, 1, 4), 40, null);
		fruit.setVitamins(Arrays.asList(new Vitamins[] { A, B, B1, B2, P }));
		fruits.add(fruit);

		fruit = new Fruit(PEAR, 5, LocalDate.of(2019, 1, 6), 10, null);
		fruit.setVitamins(Arrays.asList(new Vitamins[] { B1, B2, P }));
		fruits.add(fruit);

		fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
		fruit.setVitamins(Arrays.asList(new Vitamins[] { B, C }));
		fruits.add(fruit);

		return fruits;
	}


}
