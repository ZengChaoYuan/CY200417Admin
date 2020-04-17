package service;

import java.util.List;

import bean.UserLog;

public interface UserLogService {
 List<UserLog> selectPage(String userName,String startTime,String endTime,String start,String limit);
 
 Long countPage(String userName,String startTime,String endTime);
}
