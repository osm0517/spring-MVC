package com.example.servletExam.basic.request;

import com.example.servletExam.basic.NameAgeData;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.lang.constant.Constable;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 3-2 message body(json)
     * 방식을 통해서 들어온
     * 데이터를 이용하는 방법
     * */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("RequestBodyJsonServlet.service");

        System.out.println("---json 방식을 통해서 들어온 데이터---");
        ServletInputStream inputStream = request.getInputStream();
        String s = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("s = " + s);

        NameAgeData nameAgeData = objectMapper.readValue(s, NameAgeData.class);

        System.out.println("nameAgeData = " + nameAgeData.getUsername());
        System.out.println("nameAgeData = " + nameAgeData.getAge());
        System.out.println();
    }
}
