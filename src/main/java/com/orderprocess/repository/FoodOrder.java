package com.orderprocess.repository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "FOOD_ORDER_TABLE")
public class FoodOrder {
    private int id;
    private String name;
    private double price;

    private Courses course;
    private Cuisines cuisine;

    public FoodOrder() {
    }

    public FoodOrder(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "FOOD_ID", unique = true)
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COURSE_ID")
    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUISINE_ID")
    public Cuisines getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisines cuisine) {
        this.cuisine = cuisine;
    }
}