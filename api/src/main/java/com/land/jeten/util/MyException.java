package com.land.jeten.util;


import lombok.Data;

@Data
public class MyException extends RuntimeException{

  private String code;

  private String msg;

  public MyException(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public MyException(String msg) {
    this.code = ResponseCodeEnum.SERVICE_ERROR.getCode();
    this.msg = msg;
  }

  public MyException(ResponseCodeEnum resultEnum) {
    this.code = resultEnum.getCode();
    this.msg = resultEnum.getMsg();
  }
}
