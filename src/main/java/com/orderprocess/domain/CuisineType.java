package com.orderprocess.domain;

public enum CuisineType {
    MEXICAN("Mexican"), POLISH("Polish"), ITALIAN("Italian");

    private final String name;

    CuisineType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
