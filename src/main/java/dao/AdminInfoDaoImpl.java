package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.AdminInfo;
import util.DBUtil;


public class AdminInfoDaoImpl implements AdminInfoDao {

	@Override
	public AdminInfo selectAdmin(Connection conn, String adminName, String adminPwd) {
		String sql="SELECT * FROM ADMIN_INFO WHERE ADMIN_NAME= ? AND ADMIN_PWD= ?"; 
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, adminName);
			ps.setString(2, adminPwd);
			rs=ps.executeQuery();
			while(rs.next()) {
				Long adminId=rs.getLong("ADMIN_ID");
				String adminname=rs.getString("ADMIN_NAME");
				String adminpwd=rs.getString("ADMIN_PWD");
				Long adminState=rs.getLong("ADMIN_STATE");
				Date adminCtime=rs.getDate("ADMIN_CTIME");
				Long roleId=rs.getLong("ROLE_ID");
				AdminInfo info=new AdminInfo(adminId,
						adminname,adminpwd,adminState,adminCtime,
						roleId);
				return info;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConn(conn, ps, rs);
		}
		return null;
	}

}
