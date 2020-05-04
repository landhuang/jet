package com.land.jeten.login.api;

import com.land.jeten.login.entity.UserInfo;
import com.land.jeten.login.request.RequestLogin;
import com.land.jeten.login.vo.LoginVo;
import com.land.jeten.login.vo.UserVo;
import com.land.jeten.util.JetenApiConstant;
import com.land.jeten.util.ResponseVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(JetenApiConstant.API_AUTH)
public interface LoginApi {

  @PostMapping("login")
  public ResponseVo<UserVo> login(@RequestBody RequestLogin login);

  @PostMapping("logout")
  public ResponseVo<UserInfo> logout(@RequestBody RequestLogin login);

  @PostMapping("forge-password")
  public ResponseVo<LoginVo> forgePassword(RequestLogin login);

  @PostMapping("register")
  public ResponseVo<LoginVo> register(RequestLogin login);

  @PostMapping("2step-code")
  public ResponseVo<LoginVo> towStepCode(RequestLogin login);
}
