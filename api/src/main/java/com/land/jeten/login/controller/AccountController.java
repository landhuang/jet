package com.land.jeten.login.controller;


import com.land.jeten.login.vo.UserVo;
import com.land.jeten.util.JetenApiConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(JetenApiConstant.API_ACCOUNT)
public class AccountController {

  @PostMapping("sms")
  public UserVo getSMS(){

    return null;
  }
  @GetMapping("sms_err")
  public UserVo getSmsRrr(){

    return null;
  }
}
