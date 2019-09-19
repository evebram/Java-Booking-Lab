package com.example.booking_lab.BookingLab.components;

import com.example.booking_lab.BookingLab.models.Booking;
import com.example.booking_lab.BookingLab.models.Course;
import com.example.booking_lab.BookingLab.models.Customer;
import com.example.booking_lab.BookingLab.repositories.BookingRepositories.BookingRepository;
import com.example.booking_lab.BookingLab.repositories.CourseRepositories.CourseRepository;
import com.example.booking_lab.BookingLab.repositories.CustomerRepositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        Customer customer1 = new Customer("Mat", "Dunkeld", 34);
        customerRepository.save(customer1);

        Customer customer2 = new Customer( "Crawford", "Oban", 28);
        customerRepository.save(customer2);

        Course course1 = new Course("Woodworking", "Fort William", 3);
        courseRepository.save(course1);

        Course course2 = new Course( "Codeclan", "Crail", 5);
        courseRepository.save(course2);

        Booking booking1 = new Booking( "24.09.19", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking( "01.10.19", course2, customer2);
        bookingRepository.save(booking2);

    }
}
