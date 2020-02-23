package com.orderprocess;

import com.orderprocess.foodObjects.FoodObject;
import com.orderprocess.repository.DessertsList;
import com.orderprocess.repository.DrinksList;
import com.orderprocess.repository.MealsList;
import com.orderprocess.repository.FoodObjectsRepository;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FoodOrderMenu {
    private final static FoodObjectsRepository mealsList = new MealsList();
    private final static FoodObjectsRepository dessertsList = new DessertsList();
    private final static FoodObjectsRepository drinksList = new DrinksList();
    private final static Scanner scanner = new Scanner(System.in);

    public static boolean printFoodOrderMenu() {
        clearScreen();
        System.out.println("Welcome to our restaurant, please choose from the following options and press enter:");
        System.out.println("====================================================================");
        System.out.println();
        System.out.println("1) Display Meals Menu");
        System.out.println("2) Display Desserts Menu");
        System.out.println("3) Display Drinks Menu");
        System.out.println();
        System.out.println("====================================================================");
        System.out.println("4) Start your order");
        System.out.println("5) Receive your bill");

        System.out.println("6) Exit");

        int result = scanner.nextInt();

        switch (result) {
            case 1:
                clearScreen();
                printList(mealsList);
                System.out.println("Press enter to back to Main Menu");
                readKey();
                return true;
            case 2:
                clearScreen();
                printList(dessertsList);
                System.out.println("Press enter to back to Main Menu");
                readKey();
                return true;
            case 3:
                clearScreen();
                printList(drinksList);
                System.out.println("Press enter to back to Main Menu");
                readKey();
                return true;
            case 4:
                clearScreen();
                printOrderMenu();
                int orderResult = scanner.nextInt();

                readKey();
                return true;
            case 5:
            case 6:
                return false;
            case 7:
                printAdminMenu();
                return true;
        }
        return true;
    }

    private static void printOrderMenu() {
        clearScreen();
        printIndexedList(mealsList);
    }

    private static void printAdminMenu() {
        clearScreen();
        System.out.println("Admin menu, let you make changes to meals, drinks and dessert list");
        System.out.println("====================================================================");
        System.out.println();
        System.out.println("1) Display Main Menu");
        System.out.println("2) Display your order");
        System.out.println("3) Exit");

        int result = scanner.nextInt();

        switch (result) {
            case 1:
                clearScreen();
                printList(mealsList);
                System.out.println("Press enter to back");
                readKey();
                break;
            case 2:
                System.out.println("chuj");
                break;
            case 3:
                break;
        }
    }

    private static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Your system doesn't support console clearing" + e);
        }
    }

    private static void readKey() {
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println("There is something wrong" + e);
        }
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