package com.mySqlConnection.example.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

@Component
public class AddMyInterceptor extends WebMvcConfigurerAdapter{
    @Autowired
	MyInterceptor myinterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	// TODO Auto-generated method stub
    	registry.addInterceptor(myinterceptor);
    }
    
    
}
