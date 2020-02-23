package com.orderprocess;

import com.orderprocess.foodObjects.Dessert;
import com.orderprocess.foodObjects.FoodObject;
import com.orderprocess.foodObjects.Lunch;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Lunch> orderedLunch = new ArrayList<>();
    private final List<FoodObject> orderedDesserts = new ArrayList<>();
    private final List<FoodObject> orderedDrinks = new ArrayList<>();

    public List<Lunch> getOrderedLunch() {
        return orderedLunch;
    }

    public List<FoodObject> getOrderedDesserts() {
        return orderedDesserts;
    }

    public List<FoodObject> getOrderedDrinks() {
        return orderedDrinks;
    }

    public void addLunchToOrder(Lunch lunch) {
        orderedLunch.add(lunch);
    }

    public void addDessertToOrder(FoodObject dessert) {
        orderedDesserts.add(dessert);
    }

    public void addDrinksToOrder(FoodObject drink) {
        orderedDrinks.add(drink);
    }
}
