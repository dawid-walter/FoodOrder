package com.orderprocess.repository;

import com.orderprocess.domain.Cuisines;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisinesDao extends CrudRepository<Cuisines, Integer> {
}
