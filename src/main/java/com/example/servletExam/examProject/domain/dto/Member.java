package com.example.servletExam.examProject.domain.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private long id;
    private String username;
    private int age;

    public Member(String username, int age){
        this.username = username;
        this.age = age;
    }
}
