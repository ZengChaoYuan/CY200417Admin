package service;

import java.util.List;

import bean.FileType;

public interface FileTypeService {
 List<FileType> selectFileTypeList();
 
 List<FileType> selectPage(String typeName,String startTime,String endTime,String start,String limit);
 
 Long countPage(String typeName,String startTime,String endTime);
 
 //新增文档类型
 Integer insertFileType(FileType fileType);
 
 //修改文档类型
 Integer updateFiletype(FileType fileType);
 
 //删除文档类型
 Integer deleteFileType(Long ftId);
 
 //通过Id找到单个文档类型
 FileType selectTypeByftId(Long ftId);
 
 
 
}
