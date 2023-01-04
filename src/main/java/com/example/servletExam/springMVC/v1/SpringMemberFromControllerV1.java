package com.example.servletExam.springMVC.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMemberFromControllerV1 {

    @RequestMapping("spring-mvc/v1/members/new-form")
    public ModelAndView process(){
        System.out.println("SpringMemberFromControllerV1.process");
        return new ModelAndView("new_form");
    }
}
