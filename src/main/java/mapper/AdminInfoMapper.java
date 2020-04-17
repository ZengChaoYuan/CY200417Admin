package mapper;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import bean.AdminInfo;

public interface AdminInfoMapper {
	 //通过用户名密码查询
	 AdminInfo selectAdmin(Connection conn,String adminName,String adminPwd);
    
	 //条件查询和分页
	 List<AdminInfo> selectPage(@Param("adminName")String adminName,@Param("startTime")String startTime,
			 @Param("endTime")String endTime,@Param("roleId")String roleId,
			 @Param("adminState")Long adminState,RowBounds row);
	 
	 //计算条数
	 Long countPage(@Param("adminName")String adminName,
			 @Param("startTime")String startTime,
			 @Param("endTime")String endTime,
			 @Param("roleId")String roleId,
			 @Param("adminState")Long adminState);
	
	 //新增后台管理人员
	 Integer insertByAdmin(@Param("admin") AdminInfo admin);
	 
	 //修改后台管理人员
	 Integer updateAdminAllInfo(@Param("admin") AdminInfo admin);
	 
	 //修改后台人员的密码
	 Integer updateAdminPassword(@Param("admin") AdminInfo admin);
	 //启用/禁用
	 Integer updateAdminUseState(@Param("admin") AdminInfo admin);
	 
	 //通过Id找到对应的后台管理人员信息
	 AdminInfo selectAdminInfoById(@Param("adminId") Long adminId);
	 
	
}
