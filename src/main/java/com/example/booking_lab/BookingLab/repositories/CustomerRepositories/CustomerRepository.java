package com.example.booking_lab.BookingLab.repositories.CustomerRepositories;

import com.example.booking_lab.BookingLab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {
    List<Customer> findAllCustomersByGivenCourse(long id);
}
