package com.example.servletExam.frontcontroller;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class ModelView {
    // view 의 파일 이름 중에서 논리적인 이름만을 받음
    private String viewName;
    //모델을 저장함
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String viewName){
        this.viewName = viewName;
    }
}
