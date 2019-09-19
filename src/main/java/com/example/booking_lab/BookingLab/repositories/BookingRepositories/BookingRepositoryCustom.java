package com.example.booking_lab.BookingLab.repositories.BookingRepositories;

import com.example.booking_lab.BookingLab.models.Booking;

import java.util.List;

public interface BookingRepositoryCustom {
    List<Booking> findAllBookingsForGivenDate(String date);
}
