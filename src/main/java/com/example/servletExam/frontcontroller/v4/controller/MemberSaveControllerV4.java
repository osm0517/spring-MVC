package com.example.servletExam.frontcontroller.v4.controller;

import com.example.servletExam.examProject.domain.dto.Member;
import com.example.servletExam.examProject.domain.repository.MemberRepository;
import com.example.servletExam.frontcontroller.ModelView;
import com.example.servletExam.frontcontroller.v3.ControllerV3;
import com.example.servletExam.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        //parameter 로 넘어온 map 에 있는 정보를 받아옴
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        //넘어온 정보를 바탕으로 member 객체를 생성함
        Member member = new Member(username, age);
        //저장소에 member 객체를 넘겨서 저장함
        memberRepository.save(member);

        model.put("member", member);
        return "save-result";
    }
}
