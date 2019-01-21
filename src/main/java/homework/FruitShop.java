package homework;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Klunniy Sergey
 */
public class FruitShop {
	private String name;
	private List<Fruit> fruits;

	public FruitShop(String name, List<Fruit> fruits) {
		this.name = name;
		this.fruits = fruits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Fruit> getFruits() {
	//	getName();
		return fruits;
	}

	public void setFruits(List<Fruit> fruits) {
		this.fruits = fruits;
	}

	private boolean fruitIsValid(Fruit fruit, LocalDate date, int daysToChange) {
		return date.isAfter(fruit.getDeliveryDate())
				&& ChronoUnit.DAYS.between(fruit.getDeliveryDate(), date) <= daysToChange;
	}

	public List<Fruit> allFresh(LocalDate checkDate) {
		return getFruits().stream().filter(f -> fruitIsValid(f, checkDate, f.getDayToLive())).map(Fruit::clone)
				.collect(Collectors.toList());
	}

	public List<Fruit> allFruitOfFruitType(FruitType fruitType) {
		return getFruits().stream().filter(f -> f.getFruitType().equals(fruitType)).map(Fruit::clone)
				.collect(Collectors.toList());
	}

	public List<Fruit> checkByExpireDate(int checkDays) {
		return getFruits().stream().filter(f -> f.getDayToLive() > checkDays).map(Fruit::clone)
				.collect(Collectors.toList());
	}

	public List<Fruit> allFreshAndFruitType(FruitType fruitType, LocalDate expDate) {
		return allFruitOfFruitType(fruitType).stream().filter(f -> fruitIsValid(f, expDate, f.getDayToLive()))
				.collect(Collectors.toList());
	}

	public List<Fruit> reSetPricexRealization(int percent, int daysToChange, FruitType... fruitTypes) {
		List<FruitType> possibleTypes = Arrays.asList(fruitTypes);
		return getFruits().stream().filter(f -> possibleTypes.contains(f.getFruitType()))
				.filter(f -> fruitIsValid(f, LocalDate.now(), daysToChange)).map(Fruit::clone)
				.peek(f -> f.setPrice(f.getPrice() * percent / 100)).collect(Collectors.toList());
	}

}
