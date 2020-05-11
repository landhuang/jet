package com.land.jeten.login.entity;

import lombok.Data;

import java.util.List;


@Data
public class Role {

  private String id;
  private String name;
  private String describe;
  private String status;
  private String creatorId;
  private String createTime;
  private String merchantCode;
  private String deleted;
  private List<String> permissionList;
  private List<Permission> permissions;
}
