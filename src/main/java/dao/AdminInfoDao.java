package dao;

import java.sql.Connection;

import bean.AdminInfo;

public interface AdminInfoDao {
   AdminInfo selectAdmin(Connection conn,String adminName,String adminPwd);
}
