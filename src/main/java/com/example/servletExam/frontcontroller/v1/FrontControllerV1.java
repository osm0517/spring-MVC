package com.example.servletExam.frontcontroller.v1;

import com.example.servletExam.frontcontroller.v1.controller.MemberInputControllerV1;
import com.example.servletExam.frontcontroller.v1.controller.MemberListControllerV1;
import com.example.servletExam.frontcontroller.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.constant.Constable;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerV1 extends HttpServlet {
    
    // interface 를 사용해서 controller 를 구현한 이유
    private Map<String, ControllerV1> controllerMap = new HashMap<>();
    
    public FrontControllerV1(){
        controllerMap.put("/front-controller/v1/members/new-form", new MemberInputControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }
    /**
     * 해당 frontController 에서 모든 매핑을 해줌
     * */

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("FrontControllerV1.service");

        String requestURI = request.getRequestURI();
        ControllerV1 requestController = controllerMap.get(requestURI);

        //만약 요청한 uri 가 없을 수 있기 때문에 예외 처리
        if (requestController == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            System.out.println("uri not found");
            return;
        }

        requestController.process(request, response);
    }
}
