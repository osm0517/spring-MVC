package com.example.servletExam.frontcontroller.v5;

import com.example.servletExam.frontcontroller.ModelView;
import com.example.servletExam.frontcontroller.MyView;
import com.example.servletExam.frontcontroller.v3.ControllerV3;
import com.example.servletExam.frontcontroller.v3.controller.MemberInputControllerV3;
import com.example.servletExam.frontcontroller.v3.controller.MemberListControllerV3;
import com.example.servletExam.frontcontroller.v3.controller.MemberSaveControllerV3;
import com.example.servletExam.frontcontroller.v4.controller.MemberInputControllerV4;
import com.example.servletExam.frontcontroller.v4.controller.MemberListControllerV4;
import com.example.servletExam.frontcontroller.v4.controller.MemberSaveControllerV4;
import com.example.servletExam.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import com.example.servletExam.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerV5 extends HttpServlet {

    Map<String, Object> urlMap = new HashMap<>();
    List<MyHandlerAdapter> adapterList = new ArrayList<>();

    public FrontControllerV5(){
        //초기화 해줌
        putUrlMap();
        addAdapterList();
    }

    private void addAdapterList() {
        adapterList.add(new ControllerV3HandlerAdapter());
        adapterList.add(new ControllerV4HandlerAdapter());
    }

    private void putUrlMap() {
        urlMap.put("/front-controller/v5/v3/members/new-form", new MemberInputControllerV3());
        urlMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        urlMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        urlMap.put("/front-controller/v5/v4/members/new-form", new MemberInputControllerV4());
        urlMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        urlMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //처리 가능한 handler가 있는지 확인
        Object requestController = getHandler(request);

        //만약 요청한 uri 가 없을 수 있기 때문에 예외 처리
        if (requestController == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            System.out.println("uri not found");
            return;
        }

        //처리가 가능한 adapter가 존재하는지 확인
        MyHandlerAdapter adapter = getAdapter(requestController);

        ModelView mv = adapter.handle(request, response, requestController);

        String viewPath = getViewPath(mv);
        
        new MyView(viewPath).render(mv.getModel(), request, response);

    }

    private static String getViewPath(ModelView mv) {
        String viewName = mv.getViewName();
        return viewResolver(viewName);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return urlMap.get(requestURI);
    }

    private static String viewResolver(String viewName) {
        return "/WEB-INF/views/" + viewName + ".jsp";
    }

    private MyHandlerAdapter getAdapter(Object requestController) {
        for (MyHandlerAdapter adapter : adapterList) {
            if( adapter.supports(requestController)){
                return adapter;
            }
        }
        //처리 가능한 adapter가 존재하지 않으면 예외를 발생
        throw new IllegalArgumentException("adapter가 없어요");
    }
}
