package com.land.jeten.login.controller;


import cn.hutool.core.convert.Convert;
import com.land.jeten.login.api.LoginApi;
import com.land.jeten.login.entity.Login;
import com.land.jeten.login.entity.UserInfo;
import com.land.jeten.login.request.RequestLogin;
import com.land.jeten.login.service.LoginService;
import com.land.jeten.login.vo.LoginVo;
import com.land.jeten.login.vo.UserVo;
import com.land.jeten.util.JetenUtil;
import com.land.jeten.util.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements LoginApi {

  @Autowired
  LoginService loginService;

  public ResponseVo<UserVo> login(@RequestBody RequestLogin requestLogin) {
    Login login = JetenUtil.convert(Login.class, requestLogin);
    login = loginService.checkLogin(login);
    UserVo userVo = JetenUtil.convert(UserVo.class, login);
    userVo.setPassword(null);
    String name = userVo.getName();
    String username = login.getUsername();
    userVo.setToken(JetenUtil.createToken(name,username));
    return ResponseVo.success(userVo);
  }
  public ResponseVo<UserInfo> logout(@RequestBody RequestLogin login) {
    UserInfo userInfo = new UserInfo();
    return ResponseVo.success(userInfo);
  }
  public ResponseVo<LoginVo> forgePassword(RequestLogin login) {
    LoginVo loginVo = new LoginVo();
    return ResponseVo.success(loginVo);
  }
  public ResponseVo<LoginVo> register(RequestLogin login) {
    LoginVo loginVo = new LoginVo();
    return ResponseVo.success(loginVo);
  }
  public ResponseVo<LoginVo> towStepCode(RequestLogin login) {
    LoginVo loginVo = new LoginVo();
    loginVo.setStepCode(true);
    return ResponseVo.success(loginVo);
  }
}
