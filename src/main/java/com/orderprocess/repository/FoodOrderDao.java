package com.orderprocess.repository;

import com.orderprocess.domain.FoodOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodOrderDao extends CrudRepository<FoodOrder, Integer> {
    @Query(nativeQuery = true)
    List<FoodOrder> retrieveMainMealsList();

    @Query(nativeQuery = true)
    List<FoodOrder> retrieveDrinksList();

    @Query(nativeQuery = true)
    List<FoodOrder> retrieveDessertsList();

    List<FoodOrder> findAll();


}
