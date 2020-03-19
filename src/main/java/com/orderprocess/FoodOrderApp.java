package com.orderprocess;

import com.orderprocess.service.FoodAppDbService;
import com.orderprocess.service.OrderDbService;
import com.orderprocess.service.UiMenusPrintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FoodOrderApp {
    private UiMenusPrintingService uiMenusPrintingService;
    private FoodAppDbService foodAppDbService;
    private OrderDbService orderDbService;

    @Autowired
    public void setFoodOrderDbServiceService(FoodAppDbService foodAppDbService) {
        this.foodAppDbService = foodAppDbService;
    }

    @Autowired
    public void setUiMenusPrintingService(UiMenusPrintingService uiMenusPrintingService) {
        this.uiMenusPrintingService = uiMenusPrintingService;
    }

    @Autowired
    public void setOrderDbService(OrderDbService orderDbService) {
        this.orderDbService = orderDbService;
    }

    public boolean printFoodOrderMenu() {
        uiMenusPrintingService.printAppMenu();
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();

        switch (result) {
            case 1:
                uiMenusPrintingService.clearScreen();
                uiMenusPrintingService.printFoodList(foodAppDbService);
                return true;
            case 2:
                uiMenusPrintingService.clearScreen();
                uiMenusPrintingService.printFoodList(orderDbService);
                System.out.println("Total: " + orderDbService.calculateTotalPrice());
                return true;
            case 3:
                uiMenusPrintingService.clearScreen();
                boolean displayMenu = true;
                while (displayMenu) {
                    displayMenu = uiMenusPrintingService.printAddToOrderMenu();
                }
                return true;
            case 4:
                uiMenusPrintingService.clearScreen();
                displayMenu = true;
                while (displayMenu) {
                    displayMenu = uiMenusPrintingService.printRemoveFromOrderMenu();
                }
                return true;
            case 5:
                uiMenusPrintingService.clearScreen();
                uiMenusPrintingService.printPlaceOrderMessage();
                return true;
            case 6:
                return false;
        }
        return true;
    }

}
