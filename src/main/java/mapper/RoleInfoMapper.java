package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import bean.RoleInfo;

public interface RoleInfoMapper {

	List<RoleInfo> selectAllRole();//循环出所有的角色
	
	List<RoleInfo> selectPage(@Param("roleName")String roleName,@Param("startTime")String startTime,
			 @Param("endTime")String endTime,RowBounds row);
	
	Long countPage(@Param("roleName")String roleName,@Param("startTime")String startTime,
			 @Param("endTime")String endTime);
	
	//修改角色状态,启用,禁用
	Integer updateRoleUseState(@Param("role") RoleInfo role);
	
}
