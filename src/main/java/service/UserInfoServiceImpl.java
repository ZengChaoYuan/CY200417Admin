package service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import bean.UserInfo;
import mapper.UserInfoMapper;
import util.SqlSessionUtil;

public class UserInfoServiceImpl implements UserInfoService {

	@Override
	public List<UserInfo> selectPage(String userName, String startTime, String endTime, String userTel,String start,String limit) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
		if(userName == null||userName.trim().equals("")) {
			userName=null;
		}
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		if(userTel == null||userTel.trim().equals("")) {
			userTel=null;
		}
		List<UserInfo> users=mapper.selectPage(userName, startTime, endTime, userTel, new RowBounds(Integer.parseInt(start),
				Integer.parseInt(limit)));
		session.close();
		return users;
	}

	@Override
	public Long countPage(String userName, String startTime, String endTime, String userTel) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
		if(userName == null||userName.trim().equals("")) {
			userName=null;
		}
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		if(userTel == null||userTel.trim().equals("")) {
			userTel=null;
		}
		Long count=mapper.countPage(userName, startTime, endTime, userTel);
		session.close();
		return count;
	}

	@Override
	public Integer updateUserPassword(UserInfo user) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
		Integer info=mapper.updateUserPassword(user);
		session.commit();
		session.close();
		return info;
	}

	@Override
	public Integer updateUserUseState(UserInfo user) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
		Integer info=mapper.updateUserUseState(user);
		session.commit();
		session.close();
		return info;
	}

	@Override
	public UserInfo selectUserInfoById(Long userId) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
		UserInfo user=mapper.selectUserInfoById(userId);
		session.close();
		return user;
	}

}
