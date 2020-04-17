package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import bean.UserInfo;

public interface UserInfoMapper {//前台用户管理
	 //条件查询和分页
	 List<UserInfo> selectPage(@Param("userName")String userName,@Param("startTime")String startTime,
			 @Param("endTime")String endTime,@Param("userTel")String userTel,RowBounds row);
     
	//计算条数
		 Long countPage(@Param("userName")String userName,@Param("startTime")String startTime,
				 @Param("endTime")String endTime,@Param("userTel")String userTel);

	//重置前台人员的密码
	Integer updateUserPassword(@Param("user") UserInfo user);
	//启用/禁用
	Integer updateUserUseState(@Param("user") UserInfo user);
	//通过Id找到对应的前台人员信息
	UserInfo selectUserInfoById(@Param("userId") Long userId);
}
