package com.land.jeten.login.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_login")
public class Login {

  private Long id;
  private String username;
  private String password;
  private String avatar;
  private String status;
  private String telphone;
  private String email;
  private String wxopenid;
  private String wxunionid;
  private String remark;
  private Long createid;
  private Long createtime;
  private Long updateid;
  private Long updatetime;
}
