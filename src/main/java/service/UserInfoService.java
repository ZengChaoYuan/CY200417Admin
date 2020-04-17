package service;

import java.util.List;

import bean.UserInfo;

public interface UserInfoService {
	// 条件查询和分页
	List<UserInfo> selectPage(String userName,String startTime,
				 String endTime,String userTel,String start,String limit);
	// 计算条数
	Long countPage(String userName,String startTime,
			 String endTime,String userTel);
	 //重置前台人员密码
	 Integer updateUserPassword(UserInfo user);
	//启用/禁用
	 Integer updateUserUseState(UserInfo user);
	 //通过Id找到对应的前台人员信息 
	 UserInfo selectUserInfoById(Long userId);
}
