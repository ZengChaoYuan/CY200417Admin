package service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import bean.AdminLog;
import mapper.AdminLogMapper;
import util.SqlSessionUtil;

public class AdminLogServiceImpl implements AdminLogService {

	@Override
	public List<AdminLog> selectPage(String adminName, String startTime, String endTime, String start, String limit) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		AdminLogMapper mapper=session.getMapper(AdminLogMapper.class);
		if(adminName == null||adminName.trim().equals("")) {
			adminName=null;
		}
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		List<AdminLog> adminLog=mapper.selectPage(adminName, startTime, endTime, new RowBounds(Integer.parseInt(start),
				Integer.parseInt(limit)));
		session.close();
		return adminLog;
	}

	@Override
	public Long countPage(String adminName, String startTime, String endTime) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		AdminLogMapper mapper=session.getMapper(AdminLogMapper.class);
		if(adminName == null||adminName.trim().equals("")) {
			adminName=null;
		}
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		Long countPage=mapper.countPage(adminName, startTime, endTime);
		session.close();
		return countPage;
	}

}
