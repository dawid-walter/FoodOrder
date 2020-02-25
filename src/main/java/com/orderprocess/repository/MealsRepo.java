package com.orderprocess.repository;

import com.orderprocess.foodObjects.FoodObject;
import com.orderprocess.foodObjects.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealsRepo implements FoodObjectsRepository {
    private final List<FoodObject> mealsList = new ArrayList<>();

    public MealsRepo() {
        mealsList.add(new Meal("Beef Burger", 12.5));
        mealsList.add(new Meal("Steak", 12.5));
        mealsList.add(new Meal("Strogonof", 12.5));
        mealsList.add(new Meal("Pancake", 12.5));
    }

    public List<FoodObject> getList() {
        return mealsList;
    }

    public void addToList(FoodObject meal) {
        mealsList.add(meal);
    }

    public void removeFromList(FoodObject meal) {
        mealsList.remove(meal);
    }
}
