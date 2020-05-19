package com.land.jeten.login.controller;


import com.land.jeten.login.entity.Project;
import com.land.jeten.login.entity.User;
import com.land.jeten.login.vo.*;
import com.land.jeten.util.JetenApiConstant;
import com.land.jeten.util.PageVo;
import com.land.jeten.util.ResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(JetenApiConstant.API_WORK_PLACE)
public class WorkplaceController {

  @GetMapping("activity")
  public ResponseVo<List<ActivityVo>> getActivity(){

    ActivityVo activityVo = new ActivityVo();
    activityVo.setId(1);

    ProjectVo projectVo = new ProjectVo();
    projectVo.setAction("更新");
    projectVo.setEvent("番组计划");
    projectVo.setAction("白鹭酱油开发组");

    activityVo.setProject(projectVo);

    User user = new User();
    user.setAvatar("https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png");
    user.setNickname("@name");


    activityVo.setTime("2018-08-23 14:47:00");
    activityVo.setUser(user);

    List<ActivityVo> activityVos = new ArrayList<>();
    activityVos.add(activityVo);

    return ResponseVo.success(activityVos);
  }
  @GetMapping("teams")
  public ResponseVo<List<TeamVo>> getTeams(){
    TeamVo teamVo = new TeamVo();
    List<TeamVo> teamVos = new ArrayList<>();
    teamVos.add(teamVo);
    return ResponseVo.success(teamVos);
  }
  @GetMapping("radar")
  public ResponseVo<List<RadarVo>> getRadar(){
    RadarVo radarVo = new RadarVo();
    List<RadarVo> radarVos = new ArrayList<>();
    radarVos.add(radarVo);
    return ResponseVo.success(radarVos);
  }
}
