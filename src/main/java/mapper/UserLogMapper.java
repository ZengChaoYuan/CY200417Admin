package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import bean.UserLog;

public interface UserLogMapper {
 List<UserLog> selectPage(@Param("userName")String userName,@Param("startTime")String startTime,
		 @Param("endTime")String endTime,RowBounds row);
 
 Long countPage(@Param("userName")String userName,@Param("startTime")String startTime,
		 @Param("endTime")String endTime);
 
}
