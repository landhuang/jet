package com.land.jeten.login.vo;


import com.land.jeten.login.entity.User;
import lombok.Data;

@Data
public class ActivityVo {


  private Integer id = 1;

  private ProjectVo project;
  private User user;

  private String time;



}
