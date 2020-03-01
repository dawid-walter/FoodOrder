package com.orderprocess.repository.dao;

import com.orderprocess.repository.Courses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesDao extends CrudRepository<Courses, Integer> {
    List<Courses> findAll();
}
