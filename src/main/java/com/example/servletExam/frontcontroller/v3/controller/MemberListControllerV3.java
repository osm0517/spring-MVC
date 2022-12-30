package com.example.servletExam.frontcontroller.v3.controller;

import com.example.servletExam.examProject.domain.dto.Member;
import com.example.servletExam.examProject.domain.repository.MemberRepository;
import com.example.servletExam.frontcontroller.ModelView;
import com.example.servletExam.frontcontroller.v3.ControllerV3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap){

        List<Member> members = memberRepository.findAll();

        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);
        return mv;
    }
}
