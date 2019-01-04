package homework.home04012019;

import java.time.LocalDate;

public class Fruite {
    private Integer shelfLife;      //срок годности
    private LocalDate date;
    private Integer price;
    private Type type;

    public Fruite(Integer shelfLife, LocalDate date, Integer price, Type type) {
        this.shelfLife = shelfLife;
        this.date = date;
        this.price = price;
        this.type = type;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getPrice() {
        return price;
    }

    public Type getType() {
        return type;
    }
}
