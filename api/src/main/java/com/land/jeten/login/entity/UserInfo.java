package com.land.jeten.login.entity;


import lombok.Data;

@Data
public class UserInfo {

  private String id;
  private String name;
  private String username;
  private String password;
  private String avatar;
  private String status;
  private String telephone;
  private String lastLoginIp;
  private String lastLoginTime;
  private String creatorId;
  private String createTime;
  private String merchantCode;
  private String deleted;
  private String roleId;
  private Role role;
}
