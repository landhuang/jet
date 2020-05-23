package com.land.jeten.login.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.land.jeten.login.entity.Action;
import com.land.jeten.login.entity.ActionEntitySet;
import com.land.jeten.login.entity.Permission;
import com.land.jeten.login.entity.Role;
import com.land.jeten.login.vo.ServiceVo;
import com.land.jeten.login.vo.UserVo;
import com.land.jeten.util.JetenApiConstant;
import com.land.jeten.util.JetenUtil;
import com.land.jeten.util.PageVo;
import com.land.jeten.util.ResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(JetenApiConstant.API_HOME)
public class HomeController {

  @GetMapping("role")
  public ResponseVo<PageVo<Role>> getRole(){
    PageVo<Role> rolePageVo = new PageVo<>();
    List<Role> roles = new ArrayList<>();
    Role role = new Role();
    setPermissionList(role);
    List<String> permissionList = role.getPermissionList();
    for (String s : permissionList) {
      Permission permission = setPermissions(s);
      List<Permission> permissions = role.getPermissions();
      if(JetenUtil.ObjIsBlank(permissions)){
        permissions = new ArrayList<>();
      }
      permissions.add(permission);
      role.setPermissions(permissions);
    }
//    setPermissions(role);
    roles.add(role);
    rolePageVo.setData(roles);
    return ResponseVo.success(rolePageVo);
  }

  @GetMapping("service")
  public ResponseVo<PageVo<ServiceVo>> getService(){
    PageVo<ServiceVo> serviceVoPageVo = new PageVo<>();
    List<ServiceVo> serviceVos = new ArrayList<>();
    ServiceVo serviceVo = new ServiceVo();
    serviceVos.add(serviceVo);
    serviceVoPageVo.setData(serviceVos);
    return ResponseVo.success(serviceVoPageVo);
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

  public Permission setPermissions(String role){
    Permission permission = new Permission();

    //      case "table":
    //        permission.setPermissionId("table");
    //        permission.setPermissionName("桌子管理");
    //        permission.setRoleId("admin");
    //        setActionList(permission);
    //        setActionEntitySet(permission);
    //        setActions(permission);
    //        break;
    switch (role) {
      case "dashboard" -> {
        permission.setPermissionId("dashboard");
        permission.setPermissionName("仪表盘");
        permission.setRoleId("admin");
        setActionList(permission);
        setActionEntitySet(permission);
        setActions(permission);
      }
      case "exception" -> {
        permission.setPermissionId("exception");
        permission.setPermissionName("异常页面权限");
        permission.setRoleId("admin");
        setActionList(permission);
        setActionEntitySet(permission);
        setActions(permission);
      }
      case "result" -> {
        permission.setPermissionId("result");
        permission.setPermissionName("结果权限");
        permission.setRoleId("admin");
        setActionList(permission);
        setActionEntitySet(permission);
        setActions(permission);
      }
      case "profile" -> {
        permission.setPermissionId("profile");
        permission.setPermissionName("详细页权限");
        permission.setRoleId("admin");
        setActionList(permission);
        setActionEntitySet(permission);
        setActions(permission);
      }
      case "table" -> {
        permission.setPermissionId("table");
        permission.setPermissionName("表格权限");
        permission.setRoleId("admin");
        setActionList(permission);
        setActionEntitySet(permission);
        setActions(permission);
      }
      case "form" -> {
        permission.setPermissionId("form");
        permission.setPermissionName("表单权限");
        permission.setRoleId("admin");
        setActionList(permission);
        setActionEntitySet(permission);
        setActions(permission);
      }
      case "order" -> {
        permission.setPermissionId("order");
        permission.setPermissionName("订单管理");
        permission.setRoleId("admin");
        setActionList(permission);
        setActionEntitySet(permission);
        setActions(permission);
      }
      case "permission" -> {
        permission.setPermissionId("permission");
        permission.setPermissionName("权限管理");
        permission.setRoleId("admin");
        setActionList(permission);
        setActionEntitySet(permission);
        setActions(permission);
      }
      case "role" -> {
        permission.setPermissionId("role");
        permission.setPermissionName("角色管理");
        permission.setRoleId("admin");
        setActionList(permission);
        setActionEntitySet(permission);
        setActions(permission);
      }
      case "user" -> {
        permission.setPermissionId("user");
        permission.setPermissionName("用户管理");
        permission.setRoleId("admin");
        setActionList(permission);
        setActionEntitySet(permission);
        setActions(permission);
      }
      case "support" -> {
        permission.setPermissionId("support");
        permission.setPermissionName("超级模块");
        permission.setRoleId("admin");
        setActionList(permission);
        setActionEntitySet(permission);
        setActions(permission);
      }
    }



    return permission;
  }


  public void setActions(Permission permission) {
    permission.setActions(getListAction(permission.getActionList()));
  }

  public void setActionList(Permission permission) {
    List<String> actions = new ArrayList<>();
    actions.add("add");
    actions.add("query");
    actions.add("get");
    actions.add("update");
    actions.add("delete");

    permission.setActionList(actions);
  }

  public void setActionEntitySet(Permission permission){
    List<ActionEntitySet> actionEntitySets = new ArrayList<>();
    ActionEntitySet actionEntitySet = new ActionEntitySet();
    actionEntitySet.setAction(getListAction(permission.getActionList()));
    actionEntitySets.add(actionEntitySet);
    permission.setActionEntitySets(actionEntitySets);
  }

  public List<Action> getListAction(List<String> actions) {
    List<Action> actionList = new ArrayList<>();
    actions.forEach(a -> {
      Action action = new Action();

      switch (a) {
        case "add" -> {
          action.setAction("add");
          action.setDefaultCheck(false);
          action.setDescribe("新增");
        }
        case "query" -> {
          action.setAction("query");
          action.setDefaultCheck(false);
          action.setDescribe("查询");
        }
        case "get" -> {
          action.setAction("get");
          action.setDefaultCheck(false);
          action.setDescribe("详情");
        }
        case "update" -> {
          action.setAction("update");
          action.setDefaultCheck(false);
          action.setDescribe("修改");
        }
        case "delete" -> {
          action.setAction("delete");
          action.setDefaultCheck(false);
          action.setDescribe("删除");
        }
      }
      if (JetenUtil.isNotBlank(action.getAction())) {
        actionList.add(action);
      }
    });

    return actionList;
  }
}
