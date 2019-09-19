package com.example.booking_lab.BookingLab.repositories.CustomerRepositories;

import com.example.booking_lab.BookingLab.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    List<Customer> findAllCustomersByGivenCourse(long id);

    }
