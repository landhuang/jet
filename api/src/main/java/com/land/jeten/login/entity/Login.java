package com.land.jeten.login.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_login")
public class Login {

  private String id;
  private String username;
  private String password;
  private String status;
  private String remark;
}
