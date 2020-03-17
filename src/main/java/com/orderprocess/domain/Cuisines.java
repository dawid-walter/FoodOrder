package com.orderprocess.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUISINES_ORIGIN")
public class Cuisines {
    private int id;
    private CuisineType cuisineType;

    private List<FoodOrder> foodOrder = new ArrayList<>();

    public Cuisines() {
    }

    public Cuisines(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "CUISINE_TYPE")
    public CuisineType getCuisineOrigin() {
        return cuisineType;
    }

    public void setCuisineOrigin(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }

    @OneToMany(targetEntity = FoodOrder.class,
            mappedBy = "cuisine",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public List<FoodOrder> getFoodOrder() {
        return foodOrder;
    }

    public void setFoodOrder(List<FoodOrder> foodOrder) {
        this.foodOrder = foodOrder;
    }
}