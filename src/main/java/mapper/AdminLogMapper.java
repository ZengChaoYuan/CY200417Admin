package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import bean.AdminLog;

public interface AdminLogMapper {
  List<AdminLog> selectPage(@Param("adminName")String adminName,@Param("startTime")String startTime,
			 @Param("endTime")String endTime,RowBounds row);
  Long countPage(@Param("adminName")String adminName,@Param("startTime")String startTime,
			 @Param("endTime")String endTime);
}
