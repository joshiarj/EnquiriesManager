package com.arj.enquiry.controller;

import com.arj.enquiry.dao.EnquiryDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    
    @Autowired
    private EnquiryDAO enqDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "<h1 align=\"center\">This is admin page!</h1>";
    }
    
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model){
        model.addAttribute("totalEnquiries", enqDAO.getAll().size());
        model.addAttribute("todaysTotalEnquiries", enqDAO.getTodaysEnquiries(new Date()).size());
        model.addAttribute("possibleIncome", enqDAO.getPossibleIncome());
        return "admin/dashboard";
    }
    
    @RequestMapping(value = "/viewallenquiries", method = RequestMethod.GET)
    public String viewAllEnquiries(Model model){
        model.addAttribute("allEnquiries", enqDAO.getAll());
        return "admin/allenquiries";
    }
    
    @RequestMapping(value = "/todaysenquiries", method = RequestMethod.GET)
    public String todaysEnquiries(Model model){
        model.addAttribute("todaysEnquiries", enqDAO.getTodaysEnquiries(new Date()));
        return "admin/todaysenquiries";
    }
    
}