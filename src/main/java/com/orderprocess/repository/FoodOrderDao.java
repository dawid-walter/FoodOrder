package com.orderprocess.repository;

import com.orderprocess.domain.FoodObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodOrderDao extends CrudRepository<FoodObject, Integer> {
    List<FoodObject> findAll();
}
