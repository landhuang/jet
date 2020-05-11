package com.land.jeten.util;


import java.io.Serializable;

public class ResponseVo<T> implements Serializable {

  private String code;
  private String msg;
  private T result;

  private ResponseVo() {
  }

  public ResponseVo(ResponseCodeEnum type) {
    this.code = type.getCode();
    this.msg = type.getMsg();
  }

  public ResponseVo(ResponseCodeEnum type, T result) {
    this.result = result;
    this.code = type.getCode();
    this.msg = type.getMsg();
  }

  public ResponseVo(ResponseCodeEnum type, String content, T result) {
    this.code = type.getCode();
    this.msg = content;
    this.result = result;
  }

  public static ResponseVo<?> success() {
    return new ResponseVo<>(ResponseCodeEnum.SERVICE_SUCCESS);
  }

  public static <T> ResponseVo<T> success(T result) {
    return new ResponseVo<>(ResponseCodeEnum.SERVICE_SUCCESS, result);
  }

  public static <T> ResponseVo<T> error(T result) {
    return new ResponseVo<>(ResponseCodeEnum.SERVICE_ERROR, result);
  }

  public static  <T> ResponseVo<T> success(String content, T result) {
    return new ResponseVo<>(ResponseCodeEnum.SERVICE_SUCCESS, content, result);
  }

  public static ResponseVo<?> error() {
    return new ResponseVo<>(ResponseCodeEnum.SERVICE_ERROR);
  }

  public static ResponseVo<?> error(ResponseCodeEnum typeEnum) {
    return new ResponseVo<>(typeEnum);
  }

  public static ResponseVo<?> error(ResponseCodeEnum typeEnum, String msg) {
    return new ResponseVo<>(typeEnum,msg);
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }

}
