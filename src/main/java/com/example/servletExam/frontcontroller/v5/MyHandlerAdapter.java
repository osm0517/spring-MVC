package com.example.servletExam.frontcontroller.v5;

import com.example.servletExam.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface MyHandlerAdapter {

    /**
     * 다양한 handler 를 사용하기 위해서 interface를 만듦
     * @param adapter
     * @return
     */

    boolean supports(Object adapter);

    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
