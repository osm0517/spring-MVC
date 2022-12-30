package com.example.servletExam.frontcontroller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * render 객체를 반환하기 위해서
 * class 를 생성함.
 * 일단은 servlet 방식을 이용해서 jsp 만을
 * 렌더링한다는 생각으로 바로 class 로 구현함
 * */
public class MyView {

    private String viewPath;

    public MyView(String viewPath){
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

    }

}
