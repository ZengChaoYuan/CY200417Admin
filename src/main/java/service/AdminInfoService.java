package service;

import java.util.List;


import bean.AdminInfo;

public interface AdminInfoService {
	AdminInfo login(String name, String pwd);

	// 条件查询和分页
	List<AdminInfo> selectPage(String adminName, String startTime, String endTime, String roleId,
			Long adminState, String start,String limit);

	// 计算条数
	Long countPage(String adminName, String startTime, String endTime, String roleId, Long adminState);
	
	//新增后台管理人员
	Integer insertByAdmin(AdminInfo admin);
	
	 //修改后台管理人员
	 Integer updateAdminAllInfo(AdminInfo admin);
	 
	 //修改后台管理人员密码
	 Integer updateAdminPassword(AdminInfo admin);
	 
	 //启用/禁用
	 Integer updateAdminUseState(AdminInfo admin);
	 
	 //通过Id找到对应的后台管理人员信息
	 AdminInfo selectAdminInfoById(Long adminId);
	
	
}
