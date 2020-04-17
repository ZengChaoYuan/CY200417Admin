package service;

import java.util.List;

import bean.RoleInfo;

public interface RoleInfoService {
  //查询所有角色
  List<RoleInfo> selectAllRole();
  
  List<RoleInfo> selectPage(String roleName,String startTime,String endTime,
		  String start,String limit);
  
  Long countPage(String roleName,String startTime,String endTime);
  
  //启用/禁用
  Integer updateRoleUseState(RoleInfo role);
}
