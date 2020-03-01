package com.orderprocess;

import com.orderprocess.repository.Courses;
import com.orderprocess.repository.Cuisines;
import com.orderprocess.repository.FoodOrder;
import com.orderprocess.repository.dao.CoursesDao;
import com.orderprocess.repository.dao.CuisinesDao;
import com.orderprocess.repository.dao.FoodOrderDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TasksApplicationTests {
    @Autowired
    private CoursesDao coursesDao;
    @Autowired
    private CuisinesDao cuisinesDao;
    @Autowired
    private FoodOrderDao foodOrderDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void dataBaseAddingTest() {
        Courses mainMeal = new Courses("Main");
        Courses drink = new Courses("Drink");
        Courses dessert = new Courses("Dessert");

        Cuisines italian = new Cuisines("Italian");
        Cuisines polish = new Cuisines("Polish");
        Cuisines mexican = new Cuisines("Mexican");

        FoodOrder steak = new FoodOrder("Steak", 15.5);
        //FoodOrder burger = new FoodOrder("Burger", 11.5);
        //FoodOrder strogonof = new FoodOrder("Strogonof", 13.5);

        FoodOrder cola = new FoodOrder("Cola", 3.5);
        //FoodOrder margaritha = new FoodOrder("Margharita", 6.5);
        //FoodOrder mojito = new FoodOrder("Mojito", 4.5);

        FoodOrder cheesecake = new FoodOrder("Cheesecake", 4.5);
        //FoodOrder carrotcake = new FoodOrder("Carrotcake", 4.5);
        //FoodOrder brownie = new FoodOrder("Brownie", 2.4);

        mainMeal.getFoodOrder().add(steak);
		//mainMeal.getFoodOrder().add(burger);
		//mainMeal.getFoodOrder().add(strogonof);

		drink.getFoodOrder().add(cola);
		//drink.getFoodOrder().add(margaritha);
		//drink.getFoodOrder().add(mojito);

		dessert.getFoodOrder().add(cheesecake);
		//dessert.getFoodOrder().add(carrotcake);
		//dessert.getFoodOrder().add(brownie);

		steak.setCourse(mainMeal);
		steak.setCuisine(italian);

		cola.setCourse(drink);
		cola.setCuisine(mexican);

		cheesecake.setCourse(dessert);
		cheesecake.setCuisine(polish);

		coursesDao.save(mainMeal);
		coursesDao.save(drink);
		coursesDao.save(dessert);

		cuisinesDao.save(italian);
		cuisinesDao.save(polish);
		cuisinesDao.save(mexican);

		foodOrderDao.save(steak);
		foodOrderDao.save(cola);
		foodOrderDao.save(cheesecake);



    }

}
