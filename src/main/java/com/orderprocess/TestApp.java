/*
package com.orderprocess;

import com.orderprocess.repository.Courses;
import com.orderprocess.repository.FoodOrder;
import com.orderprocess.repository.dao.CoursesDao;
import com.orderprocess.repository.dao.FoodOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestApp {

    private static CoursesDao coursesDao;
    @Autowired
    public static void setCoursesDao(CoursesDao coursesDao) {
        TestApp.coursesDao = coursesDao;
    }

    */
/* private static FoodOrderDao foodOrderDao;

        @Autowired
        public void setFoodOrderDao(FoodOrderDao foodOrderDao) {
            this.foodOrderDao = foodOrderDao;
        }*//*

    public static void main(String[] args) {
        //List<FoodOrder> mainMeals = foodOrderDao.findByCourse("Drink");
        List<Courses> courses = coursesDao.findAll();

        for (Courses course : courses) {
            System.out.println(course);

        }

    }

}
*/
