package com.arj.enquiry.dao.impl;

import com.arj.enquiry.dao.EnquiryDAO;
import com.arj.enquiry.entity.Enquiry;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "enquiryDAO")
public class EnquiryDAOImpl implements EnquiryDAO{
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction trans;

    @Override
    public int insert(Enquiry t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        session.close();
        return result;
    }

    @Override
    public List<Enquiry> getAll() {
        List<Enquiry> enquiries = null;
        session=sessionFactory.openSession();
        enquiries=session.createQuery("Select e from Enquiry e").list();
        session.close();
        return enquiries;
    }

    @Override
    public void update(Enquiry t) {
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
        Enquiry enquiry = (Enquiry) session.get(Enquiry.class, id);
        if (enquiry != null) {
            session.delete(enquiry);
            success = true;
            trans.commit();
        }
        session.close();
        return success;
    }

    @Override
    public Enquiry getById(int id) {
        session = sessionFactory.openSession();
        Enquiry enquiry = (Enquiry) session.get(Enquiry.class, id);
        session.close();
        return enquiry;
    }

    @Override
    public double getPossibleIncome() {
        double count=0;
        for(Enquiry e:getAll()){
            count+=e.getCourseId().getCourseFee();
        }
        return count;
    }

    @Override
    public List<Enquiry> getTodaysEnquiries(Date todaysDate) {
        List<Enquiry> enquiries = null;
        session=sessionFactory.openSession();
        String sql="Select e from Enquiry e WHERE date(e.enquiryAddedDate)=:todaysDate";
        Query query=session.createQuery(sql);
        query.setParameter("todaysDate", todaysDate);
        enquiries=query.list();
        session.close();
        return enquiries;
    }
    
}
