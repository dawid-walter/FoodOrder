package com.orderprocess;

import com.orderprocess.service.FoodAppDbService;
import com.orderprocess.service.UiMenusPrintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    private static FoodOrderApp foodOrderApp;
    private static UiMenusPrintingService uiMenusPrintingService;

    @Autowired
    public void setFoodOrderApp(FoodOrderApp foodOrderApp) {
        Main.foodOrderApp = foodOrderApp;
    }

    @Autowired
    public void setUiMenusPrintingService(UiMenusPrintingService uiMenusPrintingService) {
        Main.uiMenusPrintingService = uiMenusPrintingService;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
        FoodAppDbService.fillDatabase();
        uiMenusPrintingService.clearScreen();
        boolean displayMenu = true;
        while (displayMenu) {
            displayMenu = foodOrderApp.printFoodOrderMenu();
        }
        ctx.close();
    }
}
