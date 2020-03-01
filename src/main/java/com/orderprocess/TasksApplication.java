package com.orderprocess;

import com.orderprocess.repository.Courses;
import com.orderprocess.repository.dao.CoursesDao;
import com.orderprocess.repository.dao.FoodOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TasksApplication {
    private static CoursesDao coursesDao;

    @Autowired
    public void setCoursesDao(CoursesDao coursesDao) {
        TasksApplication.coursesDao = coursesDao;
    }

	public static void main(String[] args) {
        SpringApplication.run(TasksApplication.class, args);

        List<Courses> courses = coursesDao.findAll();
        for (Courses course : courses) {
            System.out.println(course.getCourseType());

        }
    }

}
