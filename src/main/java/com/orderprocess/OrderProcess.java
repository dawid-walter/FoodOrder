package com.orderprocess;

import com.orderprocess.foodObjects.FoodObject;
import com.orderprocess.foodObjects.Lunch;
import com.orderprocess.repository.FoodObjectsRepository;
import com.orderprocess.repository.MealsList;

import java.util.Scanner;

public class OrderProcess {
    private final FoodObjectsRepository foodObjectsRepository = new MealsList();
    private final Order order = new Order();
    private final static Scanner scanner = new Scanner(System.in);

    public void orderProcessor() {
        printIndexedList(foodObjectsRepository);
        int index = scanner.nextInt();
        order.getOrderedLunch().g.add(foodObjectsRepository.getList().get(index - 1));

    }

    private static void printIndexedList(FoodObjectsRepository foodObjectsRepository) {
        int counter = 1;
        for (FoodObject foodObject : foodObjectsRepository.getList()) {
            System.out.println(counter + ") " + foodObject);
            counter++;
        }
    }

    private static void printList(FoodObjectsRepository foodObjectsRepository) {
        for (FoodObject foodObject : foodObjectsRepository.getList()) {
            System.out.println(foodObject);
        }
    }
}
