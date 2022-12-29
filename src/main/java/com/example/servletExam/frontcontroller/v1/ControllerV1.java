package com.example.servletExam.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 다형성을 이용해서 컨트롤러를 구현
 * 하면 좋은 점
 * 1. 일관성이 있음
 * 2. 매핑해줄 때 편리함
 * */

public interface ControllerV1 {

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
