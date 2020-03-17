/*
package com.orderprocess;

import com.orderprocess.foodObjects.FoodObject;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {
    private final static FoodObjectsRepository MEALS_REPO = new MealsRepo();
    private final static FoodObjectsRepository DESSERTS_REPO = new DessertsRepo();
    private final static FoodObjectsRepository DRINKS_REPO = new DrinksRepo();
    private final static Order orderList = new Order();
    private final static Scanner scanner = new Scanner(System.in);

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
                printListFromRepo(MEALS_REPO);
                System.out.println("");

                System.out.println("Press enter to back to Main Menu");

                readKey();
                return true;
            case 2:
                printListFromRepo(DESSERTS_REPO);
                System.out.println("");

                System.out.println("Press enter to back to Main Menu");
                readKey();
                return true;
            case 3:
                printListFromRepo(DRINKS_REPO);
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
                printBill();
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
        Scanner scanner = new Scanner(System.in);
        clearScreen();
        System.out.println("Order menu, let you place an order");
        System.out.println("====================================================================");
        System.out.println();
        System.out.println(" 1) Display Your Order");
        System.out.println(" 2) Add meal to your order");
        System.out.println(" 3) Remove meal from your order");
        System.out.println(" 4) Exit to Main Menu");

        int orderResult = scanner.nextInt();
        switch (orderResult) {
            case 1:
                clearScreen();
                if (orderList.getOrderedMeals().size() == 0) {
                    System.out.println("Your order is empty");
                }
                displayList(orderList.getOrderedMeals());
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
                boolean displayRemovefromOrderMenu = true;
                while (displayRemovefromOrderMenu) {
                    displayRemovefromOrderMenu = printRemoveFromOrderMenu();
                }
                return true;
            case 4:
                return false;

        }
        return true;
    }

    private static boolean printAddToOrderMenu() {
        Scanner addOrderScanner = new Scanner(System.in);
        int counter = 1;
        for (FoodObject meal : MEALS_REPO.getList()) {
            System.out.println(counter + ") " + meal);
            counter++;
        }

        System.out.println();
        System.out.println("Enter a number of meal which you would like to add to your order");
        System.out.println("Press [f] when finished");


        try {
            String index = addOrderScanner.nextLine();
            if (index.equals("f")) return false;
            orderList.getOrderedMeals().add(MEALS_REPO.getList().get(Integer.valueOf(index) - 1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You pressed wrong key, please try again");
            System.out.println("");
            return true;
        }

        System.out.println();
        System.out.println("Your order: ");
        displayList(orderList.getOrderedMeals());
        System.out.println();
        return true;
    }

    private static boolean printRemoveFromOrderMenu() {
        Scanner removeOrderScanner = new Scanner(System.in);
        int counter = 1;
        for (FoodObject meal : MEALS_REPO.getList()) {
            System.out.println(counter + ") " + meal);
            counter++;
        }
        System.out.println();
        System.out.println("Enter a number of meal which you would like to remove from your order");
        System.out.println("Press [f] when finished");

        try {
            String index = removeOrderScanner.nextLine();
            if (index.equals("f")) return false;
            orderList.getOrderedMeals().remove(MEALS_REPO.getList().get(Integer.valueOf(index) - 1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You pressed wrong key, please try again");
            System.out.println("");
            return true;
        }

        System.out.println();
        System.out.println("Your order: ");
        displayList(orderList.getOrderedMeals());
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
                printListFromRepo(MEALS_REPO);
                System.out.println("Press enter to back");
                readKey();
                return true;
            case 2:
                System.out.println("test");
                return true;
            case 3:
                return false;
        }
        return true;
    }

    private static void printBill() {
        System.out.println("Bill");
        displayList(orderList.getOrderedMeals());
        double total = orderList.getOrderedMeals().stream()
                .map(FoodObject::getPrice)
                .mapToDouble(Double::doubleValue)
                .sum();
        System.out.println("Your total: " + total);
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

    private static void printListFromRepo(FoodObjectsRepository foodObjectsRepository) {
        for (FoodObject foodObject : foodObjectsRepository.getList()) {
            System.out.println(foodObject);
        }
    }

    private static void displayList(List<FoodObject> mealList) {
        for (FoodObject meal : mealList) {
            System.out.println(meal);
        }
    }
}*/
