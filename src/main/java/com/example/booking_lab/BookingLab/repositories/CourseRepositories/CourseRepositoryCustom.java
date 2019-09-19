package com.example.booking_lab.BookingLab.repositories.CourseRepositories;

import com.example.booking_lab.BookingLab.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {

     List<Course> findAllCoursesByGivenCustomer(long id, String name);


    }
