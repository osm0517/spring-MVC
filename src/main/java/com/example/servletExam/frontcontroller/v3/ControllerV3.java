package com.example.servletExam.frontcontroller.v3;

import com.example.servletExam.frontcontroller.ModelView;
import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}
