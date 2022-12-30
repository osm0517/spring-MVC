package com.example.servletExam.frontcontroller.v3.controller;

import com.example.servletExam.frontcontroller.ModelView;
import com.example.servletExam.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberInputControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap){

        return new ModelView("new_form");

    }
}
