package com.land.jeten.login.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * filter错误处理
 */
@RestController
@Slf4j
public class ErrorController extends BasicErrorController {
  public ErrorController() {
    super(new DefaultErrorAttributes(), new ErrorProperties());
  }
  @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
    Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
    HttpStatus status = getStatus(request);
    Map<String,Object> map = new HashMap<>();
    map.put("code",body.get("status"));
    map.put("msg",body.get("message"));
    log.error(body.toString());
    return new ResponseEntity<>(map, status);
  }
}
