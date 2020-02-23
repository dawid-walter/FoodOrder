package com.orderprocess.repository;

import com.orderprocess.foodObjects.Drink;
import com.orderprocess.foodObjects.FoodObject;

import java.util.ArrayList;
import java.util.List;

public class DrinksList implements FoodObjectsRepository {
    private final List<FoodObject> drinksList = new ArrayList<>();

    public DrinksList() {
        drinksList.add(new Drink("Mojito", 3.50, false, false));
        drinksList.add(new Drink("PinaColada",4.50, false, false));
        drinksList.add(new Drink("Margaritha",3.80, false, false));
    }

    public List<FoodObject> getList() {
        return drinksList;
    }

    public void addToList(FoodObject drink) {
        drinksList.add(drink);
    }

    public void removeFromList(FoodObject drink) {
        drinksList.remove(drink);
    }
}