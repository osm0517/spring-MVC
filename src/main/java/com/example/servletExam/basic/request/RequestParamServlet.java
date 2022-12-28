package com.example.servletExam.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.constant.Constable;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    /**
     * uri => /request-param?username=seongmin&age=24&username=test
     * 1. get 방식(query string)
     * 을 통해서 넘어온 데이터를 이용하는 법
     * 2. post 방식(form data)
     * 를 통해서 넘어온 데이터를 이용하는 법
     * 3. message body 방식(json, text ...)
     * 을 통해서 넘어온 데이터를 이용하는 법
     * */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("RequestParamServlet.service");
        System.out.println();

        System.out.println("---전체 파라미터---");
        request.getParameterNames().asIterator()
                .forEachRemaining(name -> {
                    System.out.println(name + "=" + request.getParameter(name));
                });
        System.out.println();

        System.out.println("---개별로 파라미터 꺼내기---");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("---중복된 데이터 꺼내기---");
        String[] usernames = request.getParameterValues("username");
        int a = 0;
        for (String s : usernames) {
            a++;
            System.out.println("username" + a + " = " + s);
        }
    }
}
