package com.land.jeten.login.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.land.jeten.login.entity.Login;
import com.land.jeten.login.entity.UserInfo;
import com.land.jeten.login.mapper.LoginMapper;
import com.land.jeten.util.JetenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

  @Autowired
  private LoginMapper loginMapper;

  public Login checkLogin(Login login) {
    LambdaQueryWrapper<Login> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(StrUtil.isBlank(login.getUsername()),Login::getUsername, login.getUsername());
    queryWrapper.eq(StrUtil.isBlank(login.getPassword()),Login::getPassword, login.getPassword());
    login = loginMapper.selectOne(queryWrapper);
    if (login == null) {
      throw new JetenException("用户名或是密码不正确");
    }else{

    }
    return login;
  }

  public static void main(String[] args) {
    System.out.println("["+SecureUtil.md5("admin")+"]");
  }
}
