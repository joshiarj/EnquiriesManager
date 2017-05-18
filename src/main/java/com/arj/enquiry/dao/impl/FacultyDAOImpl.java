package com.arj.enquiry.dao.impl;

import com.arj.enquiry.dao.FacultyDAO;
import com.arj.enquiry.entity.Faculty;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "facultyDAO")
public class FacultyDAOImpl implements FacultyDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public List<Faculty> getAll() {
        List<Faculty> faculties = null;
        session = sessionFactory.openSession();
        faculties = session.createQuery("Select f from Faculty f").list();
        session.close();
        return faculties;
    }

}
