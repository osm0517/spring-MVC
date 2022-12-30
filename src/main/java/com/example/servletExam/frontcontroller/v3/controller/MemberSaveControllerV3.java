package com.example.servletExam.frontcontroller.v3.controller;

import com.example.servletExam.examProject.domain.dto.Member;
import com.example.servletExam.examProject.domain.repository.MemberRepository;
import com.example.servletExam.frontcontroller.ModelView;
import com.example.servletExam.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap){
        //parameter 로 넘어온 map 에 있는 정보를 받아옴
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        //넘어온 정보를 바탕으로 member 객체를 생성함
        Member member = new Member(username, age);
        //저장소에 member 객체를 넘겨서 저장함
        memberRepository.save(member);
        //view 에 논리 주소를 modelview 객체에 넣어줌
        ModelView mv = new ModelView("save-result");
        //저장된 member 객체를 modelview 객체에 model 이라는 map 에 넘겨줌
        mv.getModel().put("member", member);
        //modelview 객체를 return 해줌
        return mv;
    }
}
