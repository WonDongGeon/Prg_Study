package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // static 폴더 내의 파일을 제공하려면
        registry.addResourceHandler("/**")
.addResourceLocations("classpath:/templates/","classpath:/static/")
.setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }
}

