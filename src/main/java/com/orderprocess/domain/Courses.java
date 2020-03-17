package com.orderprocess.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COURSES")
public class Courses {
    private int id;
    private CourseType courseType;

    private List<FoodOrder> foodOrder = new ArrayList<>();

    public Courses() {
    }

    public Courses(CourseType courseType) {
        this.courseType = courseType;
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
    @Column(name = "COURSE_TYPE")
    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    @OneToMany(targetEntity = FoodOrder.class,
            mappedBy = "course",
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