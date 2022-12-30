package com.example.servletExam.frontcontroller.v2.controller;

import com.example.servletExam.frontcontroller.MyView;
import com.example.servletExam.frontcontroller.v1.ControllerV1;
import com.example.servletExam.frontcontroller.v2.ControllerV2;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberInputControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return new MyView("/WEB-INF/views/new_form.jsp");

    }
}
