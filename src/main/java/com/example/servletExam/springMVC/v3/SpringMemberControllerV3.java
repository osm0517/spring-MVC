package com.example.servletExam.springMVC.v3;

import com.example.servletExam.examProject.domain.dto.Member;
import com.example.servletExam.examProject.domain.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/spring-mvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")
    public String newForm(){
        return"new_form";
    }

    @GetMapping
    public String list(Model model){
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);

        return "members";
    }

    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model
    ){

        //넘어온 정보를 바탕으로 member 객체를 생성함
        Member member = new Member(username, age);
        //저장소에 member 객체를 넘겨서 저장함
        memberRepository.save(member);

        model.addAttribute("member", member);

        return "save-result";
    }
}
