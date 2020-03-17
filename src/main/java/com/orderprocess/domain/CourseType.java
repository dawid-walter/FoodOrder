package com.orderprocess.domain;

public enum CourseType {
    MAIN("Main"), DESSERT("Dessert"), DRINK("Drink");

    private final String name;

    CourseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
