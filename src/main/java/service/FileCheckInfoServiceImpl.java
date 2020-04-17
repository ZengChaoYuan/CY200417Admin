package service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import bean.FileCheckInfo;
import mapper.FileCheckInfoMapper;
import util.SqlSessionUtil;

public class FileCheckInfoServiceImpl implements FileCheckInfoService {

	@Override
	public List<FileCheckInfo> selectFileCheckList() {
		SqlSession session= SqlSessionUtil.getSqlSession();
		FileCheckInfoMapper mapper=session.getMapper(FileCheckInfoMapper.class);
		List<FileCheckInfo> fileCheckInfo=mapper.selectFileCheckList();
		session.close();
		return fileCheckInfo;
	}

	@Override
	public List<FileCheckInfo> selectPage(String fileName, String startTime, String endTime, Long ftId, String start,
			String limit) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		FileCheckInfoMapper mapper=session.getMapper(FileCheckInfoMapper.class);
		if(fileName == null||fileName.trim().equals("")) {
			fileName=null;
		}
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		if(ftId==null) {
			ftId=null;
		}
		List<FileCheckInfo> fileCheck=mapper.selectPage(fileName, startTime, endTime, ftId, new RowBounds(Integer.parseInt(start),
				Integer.parseInt(limit)));
		session.close();
		return fileCheck;
	}

	@Override
	public Long countPage(String fileName, String startTime, String endTime, Long ftId) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		FileCheckInfoMapper mapper=session.getMapper(FileCheckInfoMapper.class);
		if(fileName == null||fileName.trim().equals("")) {
			fileName=null;
		}
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		if(ftId==null) {
			ftId=null;
		}
		Long count=mapper.countPage(fileName, startTime, endTime, ftId);
		session.close();
		return count;
	}

}
