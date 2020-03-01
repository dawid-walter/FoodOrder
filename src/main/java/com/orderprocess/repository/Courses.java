package com.orderprocess.repository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COURSES")
public class Courses {
    private int id;
    private String courseType;

    private List<FoodOrder> foodOrder = new ArrayList<>();

    public Courses() {
    }

    public Courses(String courseType) {
        this.courseType = courseType;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COURSE_ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "COURSE_TYPE")
    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    @OneToMany(targetEntity = FoodOrder.class,
            mappedBy = "course",
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