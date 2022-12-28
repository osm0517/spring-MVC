package com.example.servletExam.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseHeader", urlPatterns = "/response-header")
public class ResponseHeader extends HttpServlet {

    /**
     * 1. header 설정
     * 2. cookie 생성, 설정
     * 3. content type 설정
     * */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //my_cookie라는 cookie를 생성함
        Cookie cookie = new Cookie("my_cookie", "cookie_value");
        //cookie는 600초 동안 유지하도록 만들어줌
        cookie.setMaxAge(600);
        //cookie를 생성함
        response.addCookie(cookie);

        //응답 데이터가 어떤 타입의 데이터인지를 명시해줌
        response.setContentType("text/plain");
        //응답 데이터를 인코딩할 때 어떤 방식으로 인코딩할지를 명시해줌
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("응답 데이터");

        //사용자가 지정한 헤더를 생성하고 전송할 수도 있음
        response.setHeader("my_header", "header_value");
    }
}
