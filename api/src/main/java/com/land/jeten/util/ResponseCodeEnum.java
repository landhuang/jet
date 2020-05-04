package com.land.jeten.util;

public enum ResponseCodeEnum {


  SERVICE_SUCCESS("200","成功"),
  PARAM_ERROR("40001","入参异常"),
  SERVICE_ERROR("500","服务异常");

  private String code;
  private String msg;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  ResponseCodeEnum(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
