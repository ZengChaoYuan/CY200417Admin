package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import bean.FileType;

public interface FileTypeListMapper {
  List<FileType> selectFileTypeList();
  
  List<FileType> selectPage(@Param("typeName")String typeName,@Param("startTime")String startTime,
			 @Param("endTime")String endTime,RowBounds row);
  
  Long countPage(@Param("typeName")String typeName,@Param("startTime")String startTime,
			 @Param("endTime")String endTime);
  
  
  //新增文档类型
  Integer insertFileType(@Param("fileType") FileType fileType);
  //修改文档类型
  Integer updateFiletype(@Param("fileType") FileType fileType);
  
  
  //删除文档类型
  Integer deleteFileType(@Param("ftId")Long ftId);
  
  //根据Id得到单个文档类型的所有信息
  FileType selectTypeByftId(@Param("ftId")Long ftId);
  
}
