package com.orderprocess.repository.dao;

import com.orderprocess.repository.FoodOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodOrderDao extends CrudRepository<FoodOrder, Integer> {
    List<FoodOrder> findByCourse(String courseType);
}
