package com.orderprocess;

import com.orderprocess.domain.FoodOrder;
import com.orderprocess.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class FoodOrderApp {
    private static Order orderList = new Order();
    private static FoodOrderService foodOrderService;

    @Autowired
    public void setFoodOrderService(FoodOrderService foodOrderService) {
        FoodOrderApp.foodOrderService = foodOrderService;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(FoodOrderApp.class, args);
        FoodOrderService.fillDatabase();
        boolean displayMenu = true;
        while (displayMenu) {
            displayMenu = printFoodOrderMenu();
        }
        ctx.close();
    }

    private static boolean printFoodOrderMenu() {
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
        System.out.println("= 5) Receive your bill                                                                 =");
        System.out.println("= 6) Exit                                                                              =");
        System.out.println("=                                                                                      =");
        System.out.println("========================================================================================");
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();

        switch (result) {
            case 1:
                clearScreen();
                printMainMenu();
                return true;
            case 2:
                return printYourOrder();
            case 3:
                boolean displayAddToOrderMenu = true;
                while (displayAddToOrderMenu) {
                    displayAddToOrderMenu = printAddToOrderMenu();
                }
                return true;
            case 4:
                boolean displayRemoveFromOrderMenu = true;
                while (displayRemoveFromOrderMenu) {
                    displayRemoveFromOrderMenu = printRemoveFromOrderMenu();
                }
                return true;
            case 6:
                return false;
        }
        return true;
    }

    private static void printMainMenu() {
        System.out.println("------------------- Main Meals ------------------------");
        printMeals();
        System.out.println("------------------- Main Meals ------------------------");
        printDrinks();
        System.out.println("------------------- Desserts --------------------------");
        printDesserts();
    }

    private static void printMeals() {
        System.out.println();
        List<FoodOrder> mainMealsList = foodOrderService.getMainMealsList();
        mainMealsList.forEach(mainMeal -> System.out.println(mainMeal.getName() + " " + "Price: " + mainMeal.getPrice() + " I's " + mainMeal.getCuisine().getCuisineOrigin().getName() + " dish."));
        System.out.println();
    }

    private static void printDrinks() {
        System.out.println();
        List<FoodOrder> drinksList = foodOrderService.getDrinksList();
        drinksList.forEach(drink -> System.out.println(drink.getName() + " " + "Price: " + drink.getPrice()));
        System.out.println();
    }

    private static void printDesserts() {
        System.out.println();
        List<FoodOrder> dessertsList = foodOrderService.getDessertsList();
        dessertsList.forEach(dessert -> System.out.println(dessert.getName() + " " + "Price: " + dessert.getPrice()));
        System.out.println();
    }


    private static boolean printAddToOrderMenu() {
        Scanner addOrderScanner = new Scanner(System.in);
        int counter = 1;
        List<FoodOrder> mainMealsList = foodOrderService.getMainMealsList();
        for (FoodOrder mainMeal : mainMealsList) {
            System.out.println(counter + ") " + mainMeal.getName() + " " + "Price: " + mainMeal.getPrice());
            counter++;
        }

        System.out.println();
        System.out.println("Enter a number of meal which you would like to add to your order");
        System.out.println("Press [f] when finished");

        try {
            String index = addOrderScanner.nextLine();
            if (index.equals("f")) return false;
            orderList.getOrderedMeals().add(foodOrderService.getMainMealsList().get(Integer.parseInt(index) - 1));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("You pressed wrong key, please try again");
            System.out.println();
            printYourOrder();
            return true;
        }
        clearScreen();
        System.out.println();
        printYourOrder();
        System.out.println();
        return true;
    }

    private static boolean printRemoveFromOrderMenu() {
        Scanner removeOrderScanner = new Scanner(System.in);
        int counter = 1;
        List<FoodOrder> orderList = FoodOrderApp.orderList.getOrderedMeals();
        if (orderList.size() == 0) {
            System.out.println("You haven not ordered anything yet, please make your order");
            return false;
        }
        for (FoodOrder mainMeal : orderList) {
            System.out.println(counter + ") " + mainMeal.getName() + " " + "Price: " + mainMeal.getPrice());
            counter++;
        }

        System.out.println();
        System.out.println("Enter a number of meal which you would like to remove from your order");
        System.out.println("Press [f] when finished");

        try {
            String index = removeOrderScanner.nextLine();
            if (index.equals("f")) return false;
            FoodOrderApp.orderList.getOrderedMeals().remove(Integer.parseInt(index) - 1);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("You pressed wrong key, please try again");
            System.out.println();
            printYourOrder();
            return true;
        }
        clearScreen();
        System.out.println();
        printYourOrder();
        System.out.println();
        return true;
    }

    private static boolean printYourOrder() {
        if (orderList.getOrderedMeals().size() == 0 && orderList.getOrderedDrinks().size() == 0 && orderList.getOrderedDrinks().size() == 0 ) {
            System.out.println("You haven not ordered anything yet, please make your order");
            return true;
        }
        System.out.println("Your order: ");
        System.out.println("---------------- Ordered main meals: --------------------");
        orderList.getOrderedMeals().forEach(orderedMeal -> System.out.println(orderedMeal.getName() + " " + orderedMeal.getPrice()));
        System.out.println();
        System.out.println("---------------- Ordered drinks: ------------------------");
        orderList.getOrderedDrinks().forEach(orderedDrink -> System.out.println(orderedDrink.getName() + " " + orderedDrink.getPrice()));
        System.out.println();
        System.out.println("---------------- Ordered desserts: ----------------------");
        orderList.getOrderedDesserts().forEach(orderedDessert -> System.out.println(orderedDessert.getName() + " " + orderedDessert.getPrice()));
        System.out.println();
        System.out.println("Total price: " + orderList.getOrderedMeals().stream().mapToDouble(FoodOrder::getPrice).sum());
        return true;
    }

    private static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Your system doesn't support console clearing" + e);
        }
    }
}