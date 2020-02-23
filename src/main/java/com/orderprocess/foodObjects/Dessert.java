package com.orderprocess.foodObjects;

public class Dessert implements FoodObject{
    private final String name;
    private final double price;

    public Dessert(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Dessert{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
