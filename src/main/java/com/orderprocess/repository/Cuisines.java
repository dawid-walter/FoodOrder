package com.orderprocess.repository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUISINES_ORIGIN")
public class Cuisines {
    private int id;
    private String cuisineOrigin;

    private List<FoodOrder> foodOrder = new ArrayList<>();

    public Cuisines() {
    }

    public Cuisines(String cuisineOrigin) {
        this.cuisineOrigin = cuisineOrigin;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CUISINE_ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "CUISINE_ORIGIN")
    public String getCuisineOrigin() {
        return cuisineOrigin;
    }

    public void setCuisineOrigin(String cuisineOrigin) {
        this.cuisineOrigin = cuisineOrigin;
    }

    @OneToMany(targetEntity = FoodOrder.class,
            mappedBy = "cuisine",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<FoodOrder> getFoodOrder() {
        return foodOrder;
    }

    public void setFoodOrder(List<FoodOrder> foodOrder) {
        this.foodOrder = foodOrder;
    }
}