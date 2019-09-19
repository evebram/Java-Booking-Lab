package com.example.booking_lab.BookingLab.repositories.BookingRepositories;

import com.example.booking_lab.BookingLab.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {
    List<Booking> findAllBookingsForGivenDate(String date);
}
