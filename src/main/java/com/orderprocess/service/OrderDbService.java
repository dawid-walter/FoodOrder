package com.orderprocess.service;

import com.orderprocess.domain.FoodObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDbService implements DbService {
    public List<FoodObject> orderList = new ArrayList<>();

    public List<FoodObject> getAll() {
        return orderList;
    }

    public String getName() {
        return "Order";
    }

    public double calculateTotalPrice() {
        return orderList.stream()
                .mapToDouble(FoodObject::getPrice)
                .sum();
    }
}
