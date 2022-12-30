package com.example.servletExam.frontcontroller.v3;

import com.example.servletExam.frontcontroller.ModelView;
import com.example.servletExam.frontcontroller.MyView;
import com.example.servletExam.frontcontroller.v3.controller.MemberInputControllerV3;
import com.example.servletExam.frontcontroller.v3.controller.MemberListControllerV3;
import com.example.servletExam.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.constant.Constable;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerV3 extends HttpServlet {

    // interface 를 사용해서 controller 를 구현한 이유
    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerV3(){
        controllerMap.put("/front-controller/v3/members/new-form", new MemberInputControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }
    /**
     * 해당 frontController 에서 모든 매핑을 해줌
     * */

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV3 requestController = controllerMap.get(requestURI);

        //만약 요청한 uri 가 없을 수 있기 때문에 예외 처리
        if (requestController == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            System.out.println("uri not found");
            return;
        }
        //넘어온 model 을 map 에 저장해줌
        Map<String, String> requestMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(name -> requestMap.put(name, request.getParameter(name)));

        ModelView mv = requestController.process(requestMap);
        String viewName = mv.getViewName();
        String viewPath = viewResolver(viewName);
        new MyView(viewPath).render(mv.getModel(), request, response);
    }

    // 논리주소 -> 물리주소 매핑
    private static String viewResolver(String viewName) {
        return "/WEB-INF/views/" + viewName + ".jsp";
    }
}
