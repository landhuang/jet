package com.land.jeten.login.entity;

import lombok.Data;

import java.util.List;

@Data
public class Permission {

  private String roleId;
  private String permissionId;
  private String permissionName;
  private List<Action> actions;
  private List<ActionEntitySet> actionEntitySets;

}
