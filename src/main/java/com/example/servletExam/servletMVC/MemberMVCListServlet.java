package com.example.servletExam.servletMVC;

import com.example.servletExam.examProject.domain.dto.Member;
import com.example.servletExam.examProject.domain.repository.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.constant.Constable;
import java.util.List;

@WebServlet(name = "memberMVCListServlet", urlPatterns = "/servlet-mvc/members")
public class MemberMVCListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    /**
     * 가입한 사용자들의 목록을 보여줌
     * 보여주는 목록으로는
     * 1. id
     * 2. username
     * 3. age
     * */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();

        request.setAttribute("members", members);

        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
