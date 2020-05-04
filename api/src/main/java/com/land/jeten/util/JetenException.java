package com.land.jeten.util;


import lombok.Data;

@Data
public class JetenException extends RuntimeException{

  private String code;

  private String msg;

  public JetenException(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public JetenException(String msg) {
    this.code = ResponseCodeEnum.SERVICE_ERROR.getCode();
    this.msg = msg;
  }

  public JetenException(ResponseCodeEnum resultEnum) {
    this.code = resultEnum.getCode();
    this.msg = resultEnum.getMsg();
  }
}
