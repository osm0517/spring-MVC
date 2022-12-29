package com.example.servletExam.servletMVC;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.constant.Constable;

@WebServlet(name = "memberMVCInputServlet", urlPatterns = "/servlet-mvc/members/new_form")
public class MemberMVCInputServlet extends HttpServlet {

    /**
     * 클라이언트의 요청이 들어오면 가입할 수 있는 뷰 화면을 렌더링해줌
     * forward 를 사용해서 redirect 와 다르게
     * 요청이 2번 일어나지 않고 뷰를 렌더링
     * */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String viewPath = "/WEB-INF/views/new_form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

    }
}
