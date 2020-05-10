package com.land.jeten.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.land.jeten.util.JetenException;
import com.land.jeten.util.JetenUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class JwtFilter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
    String url = httpRequest.getServletPath();
    String token = httpRequest.getHeader("token");
    if (StrUtil.isBlank(token)) {
      if (url.equals("/auth/login")) {
        filterChain.doFilter(servletRequest, servletResponse);
      } else {
        log.error("请先登陆！ url:{}]" , url);
        throw new ServletException("请先登陆！");
      }
    } else {
      token = JetenUtil.jwtRefresh(token);
      httpResponse.addHeader("isReFresh", "yes");
      httpResponse.setHeader("token", token);
    }
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
