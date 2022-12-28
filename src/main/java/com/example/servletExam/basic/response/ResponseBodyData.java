package com.example.servletExam.basic.response;

import com.example.servletExam.basic.NameAgeData;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.constant.Constable;

@WebServlet(name = "responseBodyData", urlPatterns = "/response-body")
public class ResponseBodyData extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 응답 데이터를 보내는 법
     * 1. text/html
     * 2. application/json
     * */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //객체 생성
        NameAgeData nameAgeData = new NameAgeData();
        //변수 설정
        String username = "seongmin";
        int age = 24;
        //setter를 이용해서 객체에 변수를 저장
        nameAgeData.setAge(age);
        nameAgeData.setUsername(username);
        //nameAgeData라는 객체를 문자열 변수로 변경해줌
        String s = objectMapper.writeValueAsString(nameAgeData);

        response.getWriter().write(s);
    }
}
