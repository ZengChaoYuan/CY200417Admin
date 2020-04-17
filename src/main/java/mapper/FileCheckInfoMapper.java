package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import bean.FileCheckInfo;

public interface FileCheckInfoMapper {
   List<FileCheckInfo> selectFileCheckList();//没有分页的时候
   
   List<FileCheckInfo> selectPage(@Param("fileName")String fileName,@Param("startTime")String startTime,
			 @Param("endTime")String endTime,@Param("ftId")Long ftId,RowBounds row);//分页
   
   Long countPage(@Param("fileName")String fileName,@Param("startTime")String startTime,
			 @Param("endTime")String endTime,@Param("ftId")Long ftId);
}
