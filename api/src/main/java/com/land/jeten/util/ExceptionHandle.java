package com.land.jeten.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ExceptionHandle extends ResponseEntityExceptionHandler {

  /**
   * 只捕获 IllegalArgumentException 异常
   * @param request
   * @param e
   * @return
   */
  @ExceptionHandler(value = IllegalArgumentException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  private ResponseVo illegalArgumentExceptionHandler(HttpServletRequest request, Exception e) {
    logger.error(e.getMessage(), e);
    System.out.println("IllegalArgumentException 异常: " + e.getClass().getName());
    return ResponseVo.error(ResponseCodeEnum.PARAM_ERROR,"请求地址："+request.getRequestURI());
  }

  /**
   * 只捕获 MyException 异常
   * @param request
   * @param e
   * @return
   */
  @ExceptionHandler(value = MyException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  private ResponseVo myExceptionHandler(HttpServletRequest request, MyException e) {
    logger.error(e.getMessage(), e);
    System.out.println("自定义异常 ："+ e.getMsg());
    return  ResponseVo.error(e.getMsg()+"url:"+request.getRequestURI());
  }

  /**
   * 默认异常捕获，上面两个异常没走的话走我。
   * @param request
   * @param e
   * @return
   */
  @ExceptionHandler
  @ResponseBody
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  private ResponseVo exceptionHandler(HttpServletRequest request, Exception e) {
    logger.error(e.getMessage(), e);
    System.out.println("异常 ："+ e.getClass().getName());
    request.getMethod();
    return ResponseVo.error(ResponseCodeEnum.SERVICE_ERROR,"不符合上述异常的默认走我这");
  }
}

