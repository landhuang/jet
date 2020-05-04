package com.land.jeten.util;


import java.io.Serializable;

public class ResponseVo<T> implements Serializable {

  private String code;
  private String msg;
  private T data;

  private ResponseVo() {
  }

  public ResponseVo(ResponseCodeEnum type) {
    this.code = type.getCode();
    this.msg = type.getMsg();
  }

  public ResponseVo(ResponseCodeEnum type, T data) {
    this.data = data;
    this.code = type.getCode();
    this.msg = type.getMsg();
  }

  public ResponseVo(ResponseCodeEnum type, String content, T data) {
    this.code = type.getCode();
    this.msg = content;
    this.data = data;
  }

  public static ResponseVo success() {
    return new ResponseVo(ResponseCodeEnum.SERVICE_SUCCESS);
  }

  public static <T> ResponseVo<T> success(T data) {
    return new ResponseVo(ResponseCodeEnum.SERVICE_SUCCESS, data);
  }

  public static <T> ResponseVo<T> error(T data) {
    return new ResponseVo(ResponseCodeEnum.SERVICE_ERROR, data);
  }

  public static  <T> ResponseVo<T> success(String content, T data) {
    return new ResponseVo(ResponseCodeEnum.SERVICE_SUCCESS, content, data);
  }

  public static ResponseVo error() {
    return new ResponseVo(ResponseCodeEnum.SERVICE_ERROR);
  }

  public static ResponseVo error(ResponseCodeEnum typeEnum) {
    return new ResponseVo(typeEnum);
  }

  public static ResponseVo error(ResponseCodeEnum typeEnum, String msg) {
    return new ResponseVo(typeEnum,msg);
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

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

}
