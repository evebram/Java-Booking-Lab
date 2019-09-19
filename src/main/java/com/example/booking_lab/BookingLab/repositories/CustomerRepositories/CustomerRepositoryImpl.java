package com.example.booking_lab.BookingLab.repositories.CustomerRepositories;

import com.example.booking_lab.BookingLab.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> findAllCustomersByGivenCourse(long id){
        List<Customer> results = null;

        try {
            Session session = entityManager.unwrap(Session.class);
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "bookingAlias");
            cr.add(Restrictions.eq("bookingAlias.id", id));
            results = cr.list();
        }

        catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return results;
    }
}
