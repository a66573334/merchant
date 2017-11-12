package com.software.configuration;

import com.software.interceptor.ErrorInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by hasee on 2017/11/12.
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
//    public static String LOGIN_USER = "loginUser";
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new ErrorInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/WEB-INF/jsp/welcome.jsp");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);


    }
}