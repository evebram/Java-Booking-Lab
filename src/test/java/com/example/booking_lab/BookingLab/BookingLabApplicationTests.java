package com.example.booking_lab.BookingLab;

import com.example.booking_lab.BookingLab.models.Booking;
import com.example.booking_lab.BookingLab.models.Course;
import com.example.booking_lab.BookingLab.models.Customer;
import com.example.booking_lab.BookingLab.repositories.BookingRepositories.BookingRepository;
import com.example.booking_lab.BookingLab.repositories.CourseRepositories.CourseRepository;
import com.example.booking_lab.BookingLab.repositories.CustomerRepositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingLabApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getAllCoursesWithGivenRating() {
		List<Course> found = courseRepository.findCoursesByStarRating(3);
		assertEquals("Woodworking", found.get(0).getName());
	}

	@Test
	public void getAllCustomersByGivenCourse() {
		List<Customer> found = customerRepository.findAllCustomersByGivenCourse(2);
		assertEquals("Crawford", found.get(0).getName());
	}

	@Test
	public void getAllCoursesByGivenCustomer() {
		List<Course> found = courseRepository.findAllCoursesByGivenCustomer(1, "Matt");
		assertEquals("Woodworking", found.get(0).getName());
	}

	@Test
	public void getAllBookingsForGivenDate() {
		List<Booking> found = bookingRepository.findAllBookingsForGivenDate("24.09.19");
		assertEquals("24.09.19", found.get(0).getDate());
	}

}
