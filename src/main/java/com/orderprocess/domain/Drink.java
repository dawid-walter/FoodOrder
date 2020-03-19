package com.orderprocess.domain;

public class Drink extends FoodObject {
    private final boolean withIce;
    private final boolean withLemon;

    public Drink(String name, double price, boolean withIce, boolean withLemon) {
        super(name, price);
        this.withIce = withIce;
        this.withLemon = withLemon;
    }

    public boolean isWithIce() {
        return withIce;
    }

    public boolean isWithLemon() {
        return withLemon;
    }
}
