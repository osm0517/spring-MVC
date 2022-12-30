package com.example.servletExam.frontcontroller.v2;

import com.example.servletExam.frontcontroller.MyView;
import com.example.servletExam.frontcontroller.v1.ControllerV1;
import com.example.servletExam.frontcontroller.v1.controller.MemberInputControllerV1;
import com.example.servletExam.frontcontroller.v1.controller.MemberListControllerV1;
import com.example.servletExam.frontcontroller.v1.controller.MemberSaveControllerV1;
import com.example.servletExam.frontcontroller.v2.controller.MemberInputControllerV2;
import com.example.servletExam.frontcontroller.v2.controller.MemberListControllerV2;
import com.example.servletExam.frontcontroller.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerV2 extends HttpServlet {

    // interface 를 사용해서 controller 를 구현한 이유
    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerV2(){
        controllerMap.put("/front-controller/v2/members/new-form", new MemberInputControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }
    /**
     * 해당 frontController 에서 모든 매핑을 해줌
     * */

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV2 requestController = controllerMap.get(requestURI);

        //만약 요청한 uri 가 없을 수 있기 때문에 예외 처리
        if (requestController == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            System.out.println("uri not found");
            return;
        }

        MyView process = requestController.process(request, response);
        process.render(request, response);
    }
}
