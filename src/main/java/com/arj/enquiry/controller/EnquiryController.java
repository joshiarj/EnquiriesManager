package com.arj.enquiry.controller;

import com.arj.enquiry.dao.CourseDAO;
import com.arj.enquiry.dao.EnquiryDAO;
import com.arj.enquiry.dao.FacultyDAO;
import com.arj.enquiry.dto.EnquiryDTO;
import com.arj.enquiry.entity.Course;
import com.arj.enquiry.entity.Enquiry;
import com.arj.enquiry.entity.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/enquiry")
public class EnquiryController {

    @Autowired
    private EnquiryDAO enquiryDAO;
    @Autowired
    private FacultyDAO facultyDAO;
    @Autowired
    private CourseDAO courseDAO;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("faculties", facultyDAO.getAll());
        model.addAttribute("courses", courseDAO.getAll());
        return "enquiry/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(EnquiryDTO enqDTO) {
        Enquiry enq = new Enquiry();
        enq.setEnquiryFirstName(enqDTO.getFirstName());
        enq.setEnquiryLastName(enqDTO.getLastName());
        enq.setEnquiryEmail(enqDTO.getEmail());
        enq.setEnquiryGender(enqDTO.getGender());
        enq.setEnquiryMessage(enqDTO.getMessage());
        enq.setCourseId(new Course(enqDTO.getCourseId()));
        enq.setFacultyId(new Faculty(enqDTO.getFacultyId()));
        enq.setStatus(enqDTO.isStatus());
        enquiryDAO.insert(enq);
        return "redirect:/enquiry/add?success";
    }
}
