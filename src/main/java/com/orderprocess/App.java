package com.orderprocess;

public class App {
    public static void main(String[] args) {
        boolean displayMenu = true;
        while (displayMenu) {
            displayMenu = FoodOrderMenu.printFoodOrderMenu();
        }
    }
}