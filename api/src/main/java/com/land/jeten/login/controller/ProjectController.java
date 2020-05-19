package com.land.jeten.login.controller;


import com.land.jeten.login.entity.Project;
import com.land.jeten.util.JetenApiConstant;
import com.land.jeten.util.PageVo;
import com.land.jeten.util.ResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(JetenApiConstant.API_LIST_SEARCH)
public class ProjectController {

  @GetMapping("projects")
  public ResponseVo<PageVo<Project>> getPojects(){
    PageVo<Project> projectPageResponseVo = new PageVo<>();
    List<Project> projects = new ArrayList<>();
    Project project = new Project();
    projects.add(project);
    projectPageResponseVo.setData(projects);
    return ResponseVo.success(projectPageResponseVo);
  }


}
