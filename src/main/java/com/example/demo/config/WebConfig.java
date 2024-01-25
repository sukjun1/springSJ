package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer{
	@Value("${webpath}")
	String webpath; //첨부 폴더 경로

	//스프링 보안문제로 외부폴더에 바로 접근할수 없음 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {	
		//폴더와 상대경로 맵핑
		registry.addResourceHandler("/uploadfile/**").addResourceLocations(webpath);
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
}
