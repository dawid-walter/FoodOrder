package com.orderprocess.foodObjects;

public class Lunch {
    private final FoodObject meal;
    private final FoodObject dessert;

    public Lunch(FoodObject meal, FoodObject dessert) {
        this.meal = meal;
        this.dessert = dessert;
    }

    public FoodObject getMeal() {
        return meal;
    }

    public FoodObject getDessert() {
        return dessert;
    }
}
