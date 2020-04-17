package service;

import java.util.List;

import bean.AdminLog;

public interface AdminLogService {
  List<AdminLog> selectPage(String adminName,String startTime,String endTime,String start,String limit);
  
  Long countPage(String adminName,String startTime,String endTime);
}
