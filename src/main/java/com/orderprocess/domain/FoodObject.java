package com.orderprocess.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedNativeQuery(
        name = "FoodObject.retrieveMainMealsList",
        query = "SELECT * FROM food_order_table \n" +
                "WHERE course_id = 1",
        resultClass = FoodObject.class
)
@NamedNativeQuery(
        name = "FoodObject.retrieveDrinksList",
        query = "SELECT * FROM food_order_table \n" +
                "WHERE course_id = 8",
        resultClass = FoodObject.class
)
@NamedNativeQuery(
        name = "FoodObject.retrieveDessertsList",
        query = "SELECT * FROM food_order_table \n" +
                "WHERE course_id = 10",
        resultClass = FoodObject.class
)
@Entity
@Table(name = "FOOD_ORDER_TABLE")
public class FoodObject {
    private int id;
    private String name;
    private double price;

    private Courses course;
    private Cuisines cuisine;

    public FoodObject() {
    }

    public FoodObject(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "FOOD_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "FOOD_PRICE")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "COURSE_ID")
    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CUISINE_ID")
    public Cuisines getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisines cuisine) {
        this.cuisine = cuisine;
    }
}