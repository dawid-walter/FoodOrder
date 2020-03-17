package com.orderprocess;

import com.orderprocess.domain.FoodOrder;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<FoodOrder> orderedMeals = new ArrayList<>();
    private final List<FoodOrder> orderedDesserts = new ArrayList<>();
    private final List<FoodOrder> orderedDrinks = new ArrayList<>();

    public List<FoodOrder> getOrderedMeals() {
        return orderedMeals;
    }

    public List<FoodOrder> getOrderedDesserts() {
        return orderedDesserts;
    }

    public List<FoodOrder> getOrderedDrinks() {
        return orderedDrinks;
    }

    public void addLunchToOrder(FoodOrder meal) {
        orderedMeals.add(meal);
    }

    public void addDessertToOrder(FoodOrder dessert) {
        orderedDesserts.add(dessert);
    }

    public void addDrinksToOrder(FoodOrder drink) {
        orderedDrinks.add(drink);
    }
}

