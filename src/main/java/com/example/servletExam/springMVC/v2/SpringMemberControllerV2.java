package com.example.servletExam.springMVC.v2;

import com.example.servletExam.examProject.domain.dto.Member;
import com.example.servletExam.examProject.domain.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/spring-mvc/v2/members")
public class SpringMemberControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView newForm(){
        System.out.println("SpringMemberFromControllerV1.process");
        return new ModelAndView("new_form");
    }

    @RequestMapping
    public ModelAndView list(){
        List<Member> members = memberRepository.findAll();

        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);

        return mv;
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response){

        //parameter 로 넘어온 map 에 있는 정보를 받아옴
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        //넘어온 정보를 바탕으로 member 객체를 생성함
        Member member = new Member(username, age);
        //저장소에 member 객체를 넘겨서 저장함
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);

        return mv;
    }
}
