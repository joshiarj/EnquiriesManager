package com.arj.enquiry.dao.impl;

import com.arj.enquiry.dao.CourseDAO;
import com.arj.enquiry.entity.Course;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "courseDAO")
public class CourseDAOImpl implements CourseDAO{
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction trans;

    @Override
    public int insert(Course t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        session.close();
        return result;
    }

    @Override
    public List<Course> getAll() {
        List<Course> courses = null;
        session=sessionFactory.openSession();
        courses=session.createQuery("Select e from Course e").list();
        session.close();
        return courses;
    }

    @Override
    public void update(Course t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        session.saveOrUpdate(t);
        trans.commit();
        session.close();
    }

    @Override
    public boolean delete(int id) {
        boolean success = false;
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        Course course = (Course) session.get(Course.class, id);
        if (course != null) {
            session.delete(course);
            success = true;
            trans.commit();
        }
        session.close();
        return success;
    }

    @Override
    public Course getById(int id) {
        session = sessionFactory.openSession();
        Course course = (Course) session.get(Course.class, id);
        session.close();
        return course;
    }
    
}
