package com.example.servletExam;

import jakarta.servlet.annotation.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan // 하위 패키지에 있는 모든 서블렛을 스캔
@SpringBootApplication
public class ServletExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletExamApplication.class, args);
	}

	@Bean
	ViewResolver viewResolver(){
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
}
