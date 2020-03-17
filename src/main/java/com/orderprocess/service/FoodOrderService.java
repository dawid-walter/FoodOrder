package com.orderprocess.service;

import com.orderprocess.domain.*;
import com.orderprocess.repository.CoursesDao;
import com.orderprocess.repository.CuisinesDao;
import com.orderprocess.repository.FoodOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FoodOrderService {
    private static CoursesDao coursesDao;

    @Autowired
    public void setCoursesDao(CoursesDao coursesDao) {
        FoodOrderService.coursesDao = coursesDao;
    }

    private static FoodOrderDao foodOrderDao;

    @Autowired
    public void setFoodOrderDao(FoodOrderDao foodOrderDao) {
        FoodOrderService.foodOrderDao = foodOrderDao;
    }

    private static CuisinesDao cuisinesDao;

    @Autowired
    public void setCuisinesDao(CuisinesDao cuisinesDao) {
        FoodOrderService.cuisinesDao = cuisinesDao;
    }

    public List<FoodOrder> getMainMealsList() {
        return foodOrderDao.retrieveMainMealsList();
    }

    public List<FoodOrder> getDrinksList() {
        return foodOrderDao.retrieveDrinksList();
    }

    public List<FoodOrder> getDessertsList() {
        return foodOrderDao.retrieveDessertsList();
    }



    public List<FoodOrder> getAll() {return foodOrderDao.findAll();}

    public static void fillDatabase() {
        Courses mainMeal = new Courses(CourseType.MAIN);
        Courses drink = new Courses(CourseType.DRINK);
        Courses dessert = new Courses(CourseType.DESSERT);

        Cuisines italian = new Cuisines(CuisineType.ITALIAN);
        Cuisines polish = new Cuisines(CuisineType.POLISH);
        Cuisines mexican = new Cuisines(CuisineType.MEXICAN);

        FoodOrder steak = new FoodOrder("Steak", 15.5);
        FoodOrder burger = new FoodOrder("Burger", 11.5);
        FoodOrder strogonof = new FoodOrder("Strogonof", 13.5);

        FoodOrder cola = new FoodOrder("Cola", 3.5);
        //FoodOrder margaritha = new FoodOrder("Margharita", 6.5);
        //FoodOrder mojito = new FoodOrder("Mojito", 4.5);

        FoodOrder cheesecake = new FoodOrder("Cheesecake", 4.5);
        //FoodOrder carrotcake = new FoodOrder("Carrotcake", 4.5);
        //FoodOrder brownie = new FoodOrder("Brownie", 2.4);


        mainMeal.getFoodOrder().add(steak);
        mainMeal.getFoodOrder().add(burger);
        mainMeal.getFoodOrder().add(strogonof);

        drink.getFoodOrder().add(cola);


        steak.setCourse(mainMeal);
        burger.setCourse(mainMeal);
        strogonof.setCourse(mainMeal);

        cola.setCourse(drink);


        //italian.getFoodOrder().add(steak);
        //polish.getFoodOrder().add(burger);
        //mexican.getFoodOrder().add(strogonof);

        steak.setCuisine(italian);
        burger.setCuisine(polish);
        strogonof.setCuisine(mexican);





       // drink.getFoodOrder().add(cola);
        //drink.getFoodOrder().add(margaritha);
        //drink.getFoodOrder().add(mojito);

        //dessert.getFoodOrder().add(cheesecake);
        //dessert.getFoodOrder().add(carrotcake);
        //dessert.getFoodOrder().add(brownie);



        /*strogonof.setCourse(mainMeal);
        strogonof.setCuisine(mexican);*/

        //cola.setCourse(drink);
        //cola.setCuisine(mexican);

        //cheesecake.setCourse(dessert);
        //cheesecake.setCuisine(polish);

        coursesDao.save(mainMeal);
        coursesDao.save(drink);
        coursesDao.save(dessert);

        cuisinesDao.save(italian);
        cuisinesDao.save(polish);
        cuisinesDao.save(mexican);

        foodOrderDao.save(steak);
        foodOrderDao.save(burger);
        foodOrderDao.save(strogonof);

        foodOrderDao.save(cola);

        //foodOrderDao.save(cheesecake);


    }
}
