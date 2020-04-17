package service;

import java.sql.Connection;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import bean.AdminInfo;
import dao.AdminInfoDao;
import mapper.AdminInfoMapper;
import util.DBUtil;
import util.DaoFactory;
import util.SqlSessionUtil;


public class AdminInfoServiceImpl implements AdminInfoService {

	@Override
	public AdminInfo login(String name, String pwd) {
		Connection conn=DBUtil.getConnection();
		AdminInfoDao info=(AdminInfoDao)DaoFactory.getDaoImpl(AdminInfoDao.class.getName());
		return info.selectAdmin(conn,name, pwd);
	}

	@Override
	public List<AdminInfo> selectPage(String adminName, String startTime, String endTime, String roleId,
			Long adminState,String start,String limit) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		AdminInfoMapper mapper=session.getMapper(AdminInfoMapper.class);
		if(adminName == null||adminName.trim().equals("")) {
			adminName=null;
		}
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		if(roleId==null||roleId.trim().equals("")||roleId.equals("0")) {
			roleId=null;
		}
		if(adminState==null) {
			adminState=null;
		}
		List<AdminInfo> admins=mapper.selectPage(adminName, startTime, endTime, roleId,adminState, new RowBounds(Integer.parseInt(start),
				Integer.parseInt(limit)));
		session.close();
		return admins;
	}

	@Override
	public Long countPage(String adminName, String startTime, String endTime, String roleId,Long adminState) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		AdminInfoMapper mapper=session.getMapper(AdminInfoMapper.class);
		if(adminName == null||adminName.trim().equals("")) {
			adminName=null;
		}
		if(startTime==null||startTime.trim().equals("")) {
			startTime=null;
		}
		if(endTime==null||endTime.trim().equals("")) {
			endTime=null;
		}
		if(roleId==null||roleId.trim().equals("")||roleId.equals("0")) {
			roleId=null;
		}
		if(adminState==null) {
			adminState=null;
		}
		Long count=mapper.countPage(adminName, startTime, endTime, roleId,adminState);
		session.close();
		return count;
	}

	@Override
	public Integer insertByAdmin(AdminInfo admin) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		AdminInfoMapper mapper=session.getMapper(AdminInfoMapper.class);
		Integer info=mapper.insertByAdmin(admin);
		session.commit();
		session.close();
		return info;
	}

	@Override
	public Integer updateAdminAllInfo(AdminInfo admin) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		AdminInfoMapper mapper=session.getMapper(AdminInfoMapper.class);
		Integer info=mapper.updateAdminAllInfo(admin);
		session.commit();
		session.close();
		return info;
	}

	@Override
	public Integer updateAdminPassword(AdminInfo admin) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		AdminInfoMapper mapper=session.getMapper(AdminInfoMapper.class);
		Integer info=mapper.updateAdminPassword(admin);
		session.commit();
		session.close();
		return info;
	}

	@Override
	public Integer updateAdminUseState(AdminInfo admin) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		AdminInfoMapper mapper=session.getMapper(AdminInfoMapper.class);
		Integer info=mapper.updateAdminUseState(admin);
		session.commit();
		session.close();
		return info;
	}

	

	@Override
	public AdminInfo selectAdminInfoById(Long adminId) {
		SqlSession session= SqlSessionUtil.getSqlSession();
		AdminInfoMapper mapper=session.getMapper(AdminInfoMapper.class);
		AdminInfo admin=mapper.selectAdminInfoById(adminId);
		session.close();
		return admin;
	}

	

	

}
