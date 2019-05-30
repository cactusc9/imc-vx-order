package com.cactusc9.config.config;

import com.cactusc9.config.interceptors.MonitorInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebappConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MonitorInterceptor()).addPathPatterns("/monitor");
        super.addInterceptors(registry);
    }
}
