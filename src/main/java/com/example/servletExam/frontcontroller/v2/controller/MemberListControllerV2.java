package com.example.servletExam.frontcontroller.v2.controller;

import com.example.servletExam.examProject.domain.dto.Member;
import com.example.servletExam.examProject.domain.repository.MemberRepository;
import com.example.servletExam.frontcontroller.MyView;
import com.example.servletExam.frontcontroller.v1.ControllerV1;
import com.example.servletExam.frontcontroller.v2.ControllerV2;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();

        request.setAttribute("members", members);

        return new MyView("/WEB-INF/views/members.jsp");
    }
}
