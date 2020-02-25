package com.orderprocess.repository;

import com.orderprocess.foodObjects.Dessert;
import com.orderprocess.foodObjects.FoodObject;

import java.util.ArrayList;
import java.util.List;

public class DessertsRepo implements FoodObjectsRepository {
    private final List<FoodObject> dessertList = new ArrayList<>();

    public DessertsRepo() {
        dessertList.add(new Dessert("Carrot Cake", 2.5));
        dessertList.add(new Dessert("Chessecake", 3.5));
        dessertList.add(new Dessert("Chocolate Gatou", 4.5));
    }

    public List<FoodObject> getList() {
        return dessertList;
    }

    public void addToList(FoodObject dessert) {
        dessertList.add(dessert);
    }

    public void removeFromList(FoodObject dessert) {
        dessertList.remove(dessert);
    }
}
