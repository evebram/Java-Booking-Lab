package com.example.booking_lab.BookingLab.repositories.CourseRepositories;

import com.example.booking_lab.BookingLab.models.Course;
import com.example.booking_lab.BookingLab.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Course> findAllCoursesByGivenCustomer(long id, String name){
        List<Course> results = null;
        try {
            Session session = entityManager.unwrap(Session.class);
            Criteria cr = session.createCriteria(Course.class);
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



