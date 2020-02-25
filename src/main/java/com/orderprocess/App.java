package com.orderprocess;

import com.orderprocess.foodObjects.FoodObject;
import com.orderprocess.repository.DessertsList;
import com.orderprocess.repository.DrinksList;
import com.orderprocess.repository.FoodObjectsRepository;
import com.orderprocess.repository.MealsList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final static FoodObjectsRepository mealsList = new MealsList();
    private final static FoodObjectsRepository dessertsList = new DessertsList();
    private final static FoodObjectsRepository drinksList = new DrinksList();
    private final static List<FoodObject> orderList = new ArrayList<>();
    private final static Scanner scanner = new Scanner(System.in);
    private final static int result = 0;
    private static boolean ext = true;

    public static void main(String[] args) {
        boolean displayMenu = true;
        while (displayMenu) {
            displayMenu = printFoodOrderMenu();
        }

    }

    public static boolean printFoodOrderMenu() {
        clearScreen();
        System.out.println("========================================================================================");
        System.out.println("= Welcome to our restaurant, please choose from the following options and press enter: =");
        System.out.println("========================================================================================");
        System.out.println("=                                                                                      =");
        System.out.println("= 1) Display Meals Menu                                                                =");
        System.out.println("= 2) Display Desserts Menu                                                             =");
        System.out.println("= 3) Display Drinks Menu                                                               =");
        System.out.println("=                                                                                      =");
        System.out.println("========================================================================================");
        System.out.println("= 4) Start your order                                                                  =");
        System.out.println("= 5) Receive your bill                                                                 =");
        System.out.println("= 6) Exit                                                                              =");
        System.out.println("========================================================================================");

        //do {
        int result = scanner.nextInt();

        switch (result) {
            case 1:
                printList(mealsList);
                System.out.println("");

                System.out.println("Press enter to back to Main Menu");

                readKey();
                return true;
            case 2:
                printList(dessertsList);
                System.out.println("");

                System.out.println("Press enter to back to Main Menu");
                readKey();
                return true;
            case 3:
                printList(drinksList);
                System.out.println("");

                System.out.println("Press enter to back to Main Menu");
                readKey();
                return true;
            case 4:
                boolean displayOrderMenu = true;
                while (displayOrderMenu) {
                    displayOrderMenu = printOrderMenu();
                }
                return true;
            case 5:
                return true;
            case 6:
                return false;
            case 7:
                boolean displayAdminyMenu = true;
                clearScreen();
                while (displayAdminyMenu) {
                    displayAdminyMenu = printAdminMenu();
                    ;
                }
        }
        return true;
    }

    private static boolean printOrderMenu() {
        MealsList mealsList = new MealsList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Order menu, let you make an order");
        System.out.println("====================================================================");
        System.out.println();
        System.out.println("1) Display Your Order");
        System.out.println("2) Add meal to your order");
        System.out.println("3) Exit to Main Menu");

        int orderResult = scanner.nextInt();
        switch (orderResult) {
            case 1:
                clearScreen();
                if (orderList.size() == 0) {
                    System.out.println("Your order is empty");
                }
                displayList(orderList);
                System.out.println("Press enter to back");
                readKey();
                return true;
            case 2:
                boolean displayAddToOrderMenu = true;
                while (displayAddToOrderMenu) {
                    displayAddToOrderMenu = printAddToOrderMenu();
                }
                return true;
            case 3:
                return false;
        }
        return true;
    }

    private static boolean printAddToOrderMenu() {
        Scanner orderScanner = new Scanner(System.in);
        int counter = 1;
        for (FoodObject meal : mealsList.getList()) {
            System.out.println(counter + ") " + meal);
            counter++;
        }

        System.out.println();
        System.out.println("Enter a number of meal which you would like add to your order");
        System.out.println("Press [f] when finished");

        String index = orderScanner.nextLine();
        if (index.equals("f")) return false;
        orderList.add(mealsList.getList().get(Integer.valueOf(index) - 1));

        System.out.println();
        System.out.println("Your order: ");
        displayList(orderList);
        System.out.println();
        return true;
    }

    private static boolean printAdminMenu() {
        System.out.println("Admin menu, let you make changes to meals, drinks and dessert list");
        System.out.println("====================================================================");
        System.out.println();
        System.out.println("1) Display Main Menu");
        System.out.println("2) Display your order");
        System.out.println("3) Exit");

        int adminResult = scanner.nextInt();
        switch (adminResult) {
            case 1:
                clearScreen();
                printList(mealsList);
                System.out.println("Press enter to back");
                readKey();
                return true;
            case 2:
                System.out.println("chuj");
                return true;
            case 3:
                return false;
        }
        return true;
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

    private static void displayList(List<FoodObject> mealList) {
        for (FoodObject meal : mealList) {
            System.out.println(meal);
        }
    }
}