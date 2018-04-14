package com.ponloo.extend.config;

import com.ponloo.extend.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/7/18.
 */
@Configuration
public class WebApiConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // token拦截器
        registry.addInterceptor(tokenInterceptor());
    }


    @Bean
    TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }
}
