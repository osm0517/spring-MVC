package com.example.servletExam.frontcontroller.v5.adapter;

import com.example.servletExam.frontcontroller.ModelView;
import com.example.servletExam.frontcontroller.v3.ControllerV3;
import com.example.servletExam.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    /**
     * ControllerV3 를 상속받은 class를 처리해주기 위해서 adapter를 만듦
     * @param adapter
     * @return
     */

    @Override
    public boolean supports(Object adapter) {
        return (adapter instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV3 controller = (ControllerV3) handler;

        Map<String, String> paramMap = new HashMap<>();

        paramMap = requestGetParameter(request, paramMap);

        ModelView mv = controller.process(paramMap);
        return mv;
    }

    private static Map<String, String> requestGetParameter(HttpServletRequest request, Map<String, String> paramMap) {
        request.getParameterNames().asIterator()
                .forEachRemaining(name -> paramMap.put(name, request.getParameter(name)));
        return paramMap;
    }
}