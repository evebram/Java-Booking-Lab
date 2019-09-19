package com.example.booking_lab.BookingLab.repositories.CourseRepositories;

import com.example.booking_lab.BookingLab.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {
    List<Course> findAllCoursesByGivenCustomer(long id, String name);

    List<Course> findCoursesByStarRating(int starRating);

}
