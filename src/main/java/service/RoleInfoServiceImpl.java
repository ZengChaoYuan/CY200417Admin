package service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import bean.RoleInfo;
import mapper.RoleInfoMapper;
import util.SqlSessionUtil;

public class RoleInfoServiceImpl implements RoleInfoService {

	@Override
	public List<RoleInfo> selectAllRole() {
		SqlSession session= SqlSessionUtil.getSqlSession();
		RoleInfoMapper mapper=session.getMapper(RoleInfoMapper.class);
		List<RoleInfo> roles=mapper.selectAllRole();
		session.close();
		return roles;
	}

	@Override
	public List<RoleInfo> selectPage(String roleName, String startTime, String endTime, String start, String limit) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		RoleInfoMapper mapper=session.getMapper(RoleInfoMapper.class);
		if(roleName == null||roleName.trim().equals("")) {
			roleName=null;
		}
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		List<RoleInfo> roles=mapper.selectPage(roleName, startTime, endTime, new RowBounds(Integer.parseInt(start),Integer.parseInt(limit)));
		session.close();
		return roles;
	}

	@Override
	public Long countPage(String roleName, String startTime, String endTime) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		RoleInfoMapper mapper=session.getMapper(RoleInfoMapper.class);
		if(roleName == null||roleName.trim().equals("")) {
			roleName=null;
		}
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		Long count=mapper.countPage(roleName, startTime, endTime);
		session.close();
		return count;
	}

	@Override
	public Integer updateRoleUseState(RoleInfo role) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		RoleInfoMapper mapper=session.getMapper(RoleInfoMapper.class);
		Integer info=mapper.updateRoleUseState(role);
		session.commit();
		session.close();
		return info;
	}

}
