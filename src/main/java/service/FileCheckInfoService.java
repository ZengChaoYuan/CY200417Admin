package service;

import java.util.List;

import bean.FileCheckInfo;

public interface FileCheckInfoService {
	//查询所有的文件审核
	List<FileCheckInfo> selectFileCheckList();
	
	//查询所有的文件审核，连表查询
	List<FileCheckInfo> selectPage(String fileName,
			String startTime, String endTime,Long ftId,String start,String limit);
	
	Long countPage(String fileName,String startTime, String endTime,Long ftId);
	
}
