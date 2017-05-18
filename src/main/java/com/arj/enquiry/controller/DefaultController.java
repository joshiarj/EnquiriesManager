package com.arj.enquiry.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class DefaultController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest req){
        req.getSession().invalidate();
        return "redirect:/";
    }
}
