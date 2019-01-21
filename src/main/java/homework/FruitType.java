package homework;

/**
 * @author Klunniy Sergey
 */
public enum FruitType {
	STRAWBERRY("Strawberry"), APPLE("apple"), PEAR("Pear"), ORANGE("Orange");

	FruitType(String name) {
		this.name = name;
	}

	private String name;

	public String toString() {
		return name;
	}

}
