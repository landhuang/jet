package com.land.jeten.login.controller;


import com.land.jeten.login.vo.UserVo;
import com.land.jeten.util.JetenApiConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(JetenApiConstant.API_USER)
public class UserController {

  @GetMapping("info")
  public UserVo getUserInfo(){

    return null;
  }
  @GetMapping("nav")
  public UserVo getNav(){

    return null;
  }
}
