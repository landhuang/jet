package com.land.jeten.login.vo;

import com.land.jeten.login.entity.UserInfo;
import lombok.Data;

@Data
public class UserVo extends UserInfo {

  private String token;
}
