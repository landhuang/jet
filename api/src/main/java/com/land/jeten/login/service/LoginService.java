package com.land.jeten.login.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.land.jeten.login.entity.Login;
import com.land.jeten.login.entity.UserInfo;
import com.land.jeten.login.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

  @Autowired
  private LoginMapper loginMapper;


  public UserInfo checkLogin(Login login) {

    UserInfo userInfo = new UserInfo();


    List<Login> logins = loginMapper.selectList(null);


    for (Login l : logins) {
      System.out.println("l:" + l);
    }

    LambdaQueryWrapper<Login> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(StrUtil.isBlank(login.getUsername()),Login::getUsername, login.getUsername());
    login = loginMapper.selectOne(queryWrapper);

    System.out.println("login:" + login);

    return userInfo;

  }


  public static void main(String[] args) {
    System.out.println("["+SecureUtil.md5("admin")+"]");
  }
}
