package com.orderprocess.repository.dao;

import com.orderprocess.repository.Cuisines;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisinesDao extends CrudRepository<Cuisines, Integer> {
}
