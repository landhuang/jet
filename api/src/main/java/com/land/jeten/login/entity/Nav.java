package com.land.jeten.login.entity;


import lombok.Data;

@Data
public class Nav {

  private String name;
  private String parentId;
  private String id;
  private String component;
  private String redirect;

  private Meta meta;
}
