package service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import bean.FileType;
import mapper.FileTypeListMapper;
import util.SqlSessionUtil;

public class FileTypeServiceImpl implements FileTypeService {

	@Override
	public List<FileType> selectFileTypeList() {
		SqlSession session= SqlSessionUtil.getSqlSession();
		FileTypeListMapper mapper=session.getMapper(FileTypeListMapper.class);
		List<FileType> fileType=mapper.selectFileTypeList();
		session.close();
		return fileType;
	}

	@Override
	public List<FileType> selectPage(String typeName, String startTime, String endTime, String start, String limit) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		FileTypeListMapper mapper=session.getMapper(FileTypeListMapper.class);
		if(typeName == null||typeName.trim().equals("")) {
			typeName=null;
		}
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		List<FileType> fileType=mapper.selectPage(typeName, startTime, endTime, new RowBounds(Integer.parseInt(start),Integer.parseInt(limit)));
		session.close();
		return fileType;
	}

	@Override
	public Long countPage(String typeName, String startTime, String endTime) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		FileTypeListMapper mapper=session.getMapper(FileTypeListMapper.class);
		if(typeName == null||typeName.trim().equals("")) {
			typeName=null;
		}
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		Long count=mapper.countPage(typeName, startTime, endTime);
		session.close();
		return count;
	}

	@Override
	public Integer insertFileType(FileType fileType) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		FileTypeListMapper mapper=session.getMapper(FileTypeListMapper.class);
		Integer type=mapper.insertFileType(fileType);
		session.commit();
		session.close();
		return type;
	}

	@Override
	public Integer deleteFileType(Long ftId) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		FileTypeListMapper mapper=session.getMapper(FileTypeListMapper.class);
		Integer type=mapper.deleteFileType(ftId);
		session.commit();
		session.close();
		return type;
	}

	@Override
	public FileType selectTypeByftId(Long ftId) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		FileTypeListMapper mapper=session.getMapper(FileTypeListMapper.class);
		FileType type=mapper.selectTypeByftId(ftId);
		session.close();
		return type;
	}

	@Override
	public Integer updateFiletype(FileType fileType) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		FileTypeListMapper mapper=session.getMapper(FileTypeListMapper.class);
		Integer type=mapper.updateFiletype(fileType);
		session.commit();
		session.close();
		return type;
	}

}
