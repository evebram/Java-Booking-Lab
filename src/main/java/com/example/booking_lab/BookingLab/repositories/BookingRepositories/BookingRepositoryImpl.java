package com.example.booking_lab.BookingLab.repositories.BookingRepositories;

import com.example.booking_lab.BookingLab.models.Booking;
import com.example.booking_lab.BookingLab.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Booking> findAllBookingsForGivenDate(String date){
        List<Booking> results = null;

        try {
            Session session = entityManager.unwrap(Session.class);
            Criteria cr = session.createCriteria(Booking.class);
            cr.createAlias("date", "bookingAlias");
            cr.add(Restrictions.eq("bookingAlias.date", date));
            results = cr.list();
        }

        catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return results;
    }
}
