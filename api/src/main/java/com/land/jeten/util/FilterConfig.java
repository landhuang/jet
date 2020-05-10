package com.land.jeten.util;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {
  @Bean
  public FilterRegistrationBean<Filter> filterRegistrationBean1() {
    FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
    filterRegistrationBean.setFilter(jwtFilter());
    filterRegistrationBean.setName("jwtFilter");
    filterRegistrationBean.addUrlPatterns("/*");
    filterRegistrationBean.setOrder(10);
    return filterRegistrationBean;
  }
  @Bean
  public Filter jwtFilter() {
    return new JwtFilter();
  }
}
