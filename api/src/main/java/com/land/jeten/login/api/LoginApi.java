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
  ResponseVo<UserVo> login(@RequestBody RequestLogin login);

  @PostMapping("logout")
  ResponseVo<UserInfo> logout(@RequestBody RequestLogin login);

  @PostMapping("forge-password")
  ResponseVo<LoginVo> forgePassword(RequestLogin login);

  @PostMapping("register")
  ResponseVo<LoginVo> register(RequestLogin login);

  @PostMapping("2step-code")
  ResponseVo<LoginVo> towStepCode(RequestLogin login);
}
