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

@WebServlet(name = "memberMVCSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MemberMVCSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    /**
     * 사용자가 /members/new_from 에서 계정 생성 요청을 보내면
     * 해당 servlet 에서 요청을 받아 계정을 repository 에 저장함
     * */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        System.out.println("MemberMVCSaveServlet.service");
        Member member = new Member(username, age);

        memberRepository.save(member);

        request.setAttribute("member", member);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
        System.out.println("MemberMVCSaveServlet.service");
    }
}
