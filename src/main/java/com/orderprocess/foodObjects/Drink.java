package com.orderprocess.foodObjects;

public class Drink implements FoodObject{
    private final String name;
    private final double price;
    private final boolean withIce;
    private final boolean withLemon;

    public Drink(String name, double price, boolean withIce, boolean withLemon) {
        this.name = name;
        this.price = price;
        this.withIce = withIce;
        this.withLemon = withLemon;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
