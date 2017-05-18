package com.arj.enquiry.dao;

import com.arj.enquiry.entity.Enquiry;
import java.util.Date;
import java.util.List;

public interface EnquiryDAO extends GenericDAO<Enquiry> {
    double getPossibleIncome();
    List<Enquiry> getTodaysEnquiries(Date todaysDate);
}
