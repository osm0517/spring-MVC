package com.example.servletExam.frontcontroller.v4.controller;

import com.example.servletExam.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberInputControllerV4 implements ControllerV4 {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new_form";
    }
}
