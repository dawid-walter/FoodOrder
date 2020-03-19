package com.orderprocess.repository;

import com.orderprocess.domain.Cuisines;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuisinesDao extends CrudRepository<Cuisines, Integer> {
    List<Cuisines> findAll();
}
