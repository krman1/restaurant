package pl.krman.restaurant.drink;

import java.math.BigDecimal;

public class Drink {
    private Long id;
    private String name;
    private BigDecimal cost;

    public Drink(Long id, String name, BigDecimal cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return  name +" for "+ cost + " ZŁ - press " + id;
    }
}
