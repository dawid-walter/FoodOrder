package com.orderprocess.service;

import com.orderprocess.domain.FoodObject;

import java.util.List;

public interface DbService {
    public List<FoodObject> getAll();
    public String getName();

}
