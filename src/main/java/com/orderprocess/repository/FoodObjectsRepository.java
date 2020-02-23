package com.orderprocess.repository;

import com.orderprocess.foodObjects.FoodObject;

import java.util.List;

public interface FoodObjectsRepository {
    List<FoodObject> getList();
    void addToList(FoodObject meal);
    void removeFromList(FoodObject meal);
}
