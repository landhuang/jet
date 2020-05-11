package com.land.jeten.login.controller;


import com.land.jeten.login.entity.Action;
import com.land.jeten.login.entity.ActionEntitySet;
import com.land.jeten.login.entity.Permission;
import com.land.jeten.login.entity.Role;
import com.land.jeten.login.vo.UserVo;
import com.land.jeten.util.JetenApiConstant;
import com.land.jeten.util.ResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(JetenApiConstant.API_USER)
public class UserController {

  @GetMapping("info")
  public ResponseVo<UserVo> getUserInfo(){
    UserVo userVo = new UserVo();
    Role role = new Role();
    setPermissionList(role);
    setPermissions(role);


    userVo.setRole(role);
    return ResponseVo.success(userVo);
  }
  @GetMapping("nav")
  public UserVo getNav(){

    return null;
  }

  public void setPermissionList(Role role){
    List<String> permissionList = new ArrayList<>();
    permissionList.add("dashboard");
    permissionList.add("exception");
    permissionList.add("result");
    permissionList.add("profile");
    permissionList.add("table");
    permissionList.add("form");
    permissionList.add("order");
    permissionList.add("permission");
    permissionList.add("role");
    permissionList.add("table");
    permissionList.add("user");
    permissionList.add("support");
    role.setPermissionList(permissionList);
  }


  public void setPermissions(Role role){

    Permission permission = new Permission();
    setActionEntitySet(permission);
    setActionList(permission);
    setActions(permission);

    permission.setPermissionId("dashboard");
    permission.setPermissionName("仪表盘");
    permission.setRoleId("admin");

    List<Permission> listPer = new ArrayList<>();
    listPer.add(permission);

    role.setPermissions(listPer);
  }

  public void setActions(Permission permission) {
    List<Action> action = new ArrayList<>();

    List<Action> actions = new ArrayList<>();

    Action actionAdd = new Action();
    actionAdd.setAction("add");
    actionAdd.setDefaultCheck(false);
    actionAdd.setDescribe("新增");
    actions.add(actionAdd);

    Action actionQuery = new Action();
    actionQuery.setAction("query");
    actionQuery.setDefaultCheck(false);
    actionQuery.setDescribe("查询");
    actions.add(actionQuery);

    Action actionGet = new Action();
    actionGet.setAction("get");
    actionGet.setDefaultCheck(false);
    actionGet.setDescribe("详情");
    actions.add(actionGet);

    Action actionUpdate = new Action();
    actionUpdate.setAction("update");
    actionUpdate.setDefaultCheck(false);
    actionUpdate.setDescribe("修改");
    actions.add(actionUpdate);

    Action actionDelete = new Action();
    actionDelete.setAction("delete");
    actionDelete.setDefaultCheck(false);
    actionDelete.setDescribe("删除");
    actions.add(actionDelete);

    permission.setActions(actions);
  }

  public void setActionList(Permission permission) {
    List<String> action = new ArrayList<>();
    action.add("add");
    action.add("query");
    action.add("get");
    action.add("update");
    action.add("delete");

    permission.setActionList(action);
  }

  public void setActionEntitySet(Permission permission){
    List<ActionEntitySet> actionEntitySets = new ArrayList<>();
    ActionEntitySet actionEntitySet = new ActionEntitySet();
    setAction(actionEntitySet);

    actionEntitySets.add(actionEntitySet);
    permission.setActionEntitySets(actionEntitySets);
  }

  public void setAction(ActionEntitySet actionEntitySet) {

    List<Action> actions = new ArrayList<>();

    Action actionAdd = new Action();
    actionAdd.setAction("add");
    actionAdd.setDefaultCheck(false);
    actionAdd.setDescribe("新增");
    actions.add(actionAdd);

    Action actionQuery = new Action();
    actionQuery.setAction("query");
    actionQuery.setDefaultCheck(false);
    actionQuery.setDescribe("查询");
    actions.add(actionQuery);

    Action actionGet = new Action();
    actionGet.setAction("get");
    actionGet.setDefaultCheck(false);
    actionGet.setDescribe("详情");
    actions.add(actionGet);

    Action actionUpdate = new Action();
    actionUpdate.setAction("update");
    actionUpdate.setDefaultCheck(false);
    actionUpdate.setDescribe("修改");
    actions.add(actionUpdate);

    Action actionDelete = new Action();
    actionDelete.setAction("delete");
    actionDelete.setDefaultCheck(false);
    actionDelete.setDescribe("删除");
    actions.add(actionDelete);

    actionEntitySet.setAction(actions);
  }
}
