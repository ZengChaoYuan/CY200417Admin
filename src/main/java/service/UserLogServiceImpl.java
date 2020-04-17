package service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import bean.UserLog;
import mapper.UserLogMapper;
import util.SqlSessionUtil;

public class UserLogServiceImpl implements UserLogService {

	@Override
	public List<UserLog> selectPage(String userName, String startTime, String endTime, String start, String limit) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		UserLogMapper mapper=session.getMapper(UserLogMapper.class);
		if(userName == null||userName.trim().equals("")) {
			userName=null;
		}
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		List<UserLog> userLog=mapper.selectPage(userName, startTime, endTime, new RowBounds(Integer.parseInt(start),Integer.parseInt(limit)));
		session.close();
		return userLog;
	}

	@Override
	public Long countPage(String userName, String startTime, String endTime) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		UserLogMapper mapper=session.getMapper(UserLogMapper.class);
		if(userName == null||userName.trim().equals("")) {
			userName=null;
		}
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		Long count=mapper.countPage(userName, startTime, endTime);
		session.close();
		return count;
	}

}
