package com.orderprocess.service;

import com.orderprocess.domain.Courses;
import com.orderprocess.domain.FoodObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class UiMenusPrintingService {
    private FoodAppDbService foodAppDbService;
    private OrderDbService orderDbService;

    @Autowired
    public void setFoodAppDbService(FoodAppDbService foodAppDbService) {
        this.foodAppDbService = foodAppDbService;
    }

    @Autowired
    public void setOrderDbService(OrderDbService orderDbService) {
        this.orderDbService = orderDbService;
    }

    public void printAppMenu() {
        System.out.println("=/><\\=-=/><\\=-=/><\\=-=/><\\=-=/><\\=-=/><\\=-=/><\\=-=/><\\=-=/><\\=-=/><\\=-=/><\\=-=/><\\=-=/>=");
        System.out.println("========================================================================================");
        System.out.println("= Welcome to our restaurant, please choose from the following options and press enter: =");
        System.out.println("========================================================================================");
        System.out.println("=                                                                                      =");
        System.out.println("= 1) Display Main Menu                                                                 =");
        System.out.println("= 2) Display Your Order                                                                =");
        System.out.println("=                                                                                      =");
        System.out.println("========================================================================================");
        System.out.println("=                                                                                      =");
        System.out.println("= 3) Start your order                                                                  =");
        System.out.println("= 4) Remove courses from your order                                                    =");
        System.out.println("= 5) Place your order                                                                  =");
        System.out.println("= 6) Exit                                                                              =");
        System.out.println("=                                                                                      =");
        System.out.println("========================================================================================");
    }

    public boolean printAddToOrderMenu() {
        printFoodListWithCounter(foodAppDbService);
        System.out.println();
        System.out.println("Enter a number of meal which you would like to add to your order");
        System.out.println("Press [f] when finished");

        Scanner addOrderScanner = new Scanner(System.in);
        try {
            String index = addOrderScanner.nextLine();
            if (index.equals("f")) {
                clearScreen();
                return false;
            }
            orderDbService.getAll().add(foodAppDbService.getAll().get(Integer.parseInt(index) - 1));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("You pressed wrong key, please try again");
            System.out.println();
            printFoodList(orderDbService);
            return true;
        }
        clearScreen();
        System.out.println();
        printFoodList(orderDbService);
        System.out.println("Total: " + orderDbService.calculateTotalPrice());
        System.out.println();
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        return true;
    }

    public boolean printRemoveFromOrderMenu() {
        printFoodListWithCounter(orderDbService);
        System.out.println();
        System.out.println("Enter a number of meal which you would like to add to your order");
        System.out.println("Press [f] when finished");
        Scanner addOrderScanner = new Scanner(System.in);
        try {
            String index = addOrderScanner.nextLine();
            if (index.equals("f")) {
                clearScreen();
                return false;
            }
            orderDbService.getAll().remove(Integer.parseInt(index) - 1);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("You pressed wrong key, please try again");
            System.out.println();
            printFoodList(orderDbService);
            return true;
        }
        clearScreen();
        return true;
    }

    public void printFoodList(DbService dbService) {
        List<Courses> coursesList = foodAppDbService.getCourseTypesList();
        printFoodListHeader(dbService);

        coursesList.forEach(course -> {
                    System.out.println("------------------------- " + course.getCourseType().getName() + " --------------------------");
                    System.out.println();
                    dbService.getAll().stream()
                            .filter(foodObject -> (foodObject.getCourse().getCourseType().getName()).equals(course.getCourseType().getName()))
                            .forEach(foodObject -> System.out.println(foodObject.getName() + " " + foodObject.getPrice()));
                    System.out.println();
                }
        );
    }

    public void printFoodListWithCounter(DbService dbService) {
        List<Courses> coursesList = foodAppDbService.getCourseTypesList();
        printFoodListHeader(dbService);

        int counter = 1;
        for (Courses course : coursesList) {
            System.out.println("------------------------- " + course.getCourseType().getName() + " --------------------------");
            List<FoodObject> foods = dbService.getAll().stream()
                    .filter(foodObject -> (foodObject.getCourse().getCourseType().getName()).equals(course.getCourseType().getName()))
                    .collect(Collectors.toList());
            for (FoodObject foodObject : foods) {
                System.out.println(counter + ") " + foodObject.getName() + " " + foodObject.getPrice());
                counter++;
            }
        }
    }

    public void printPlaceOrderMessage() {
        System.out.println();
        System.out.println("Thank you for your order, it's processed now and should be with you shortly.");
        System.out.println();
    }

    private void printFoodListHeader(DbService dbService) {
        System.out.println("*&*-*&*-*&*-*&*-*&*-*&*-*&*-*&**&*-*&*-*&*-*&*-*&*-*&*-*&*-*&**&*-*&*-*&*-");
        System.out.println("*&*-*&*-*&*-*&*-*&*-*&*-*&*-*&*   " + dbService.getName() + "   -*&*-*&*-*&*-*&*-*&*-*&*-*&*");
        System.out.println("*&*-*&*-*&*-*&*-*&*-*&*-*&*-*&**&*-*&*-*&*-*&*-*&*-*&*-*&*-*&**&*-*&*-*&*-");
    }

    public void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Your system doesn't support console clearing" + e);
        }
    }
}