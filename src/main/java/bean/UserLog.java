package bean;

import java.sql.Date;

public class UserLog {//前台用户日志表:三表查询:用户日志表+用户表+字典表
	private Long ulId;
	private Long userId;
	private Long doName;
	private Date doCtime;
	private UserInfo userInfo;
	private DictInfo dictInfo;
	
	public UserLog(Long ulId, Long userId, Long doName, Date doCtime, UserInfo userInfo, DictInfo dictInfo) {
		super();
		this.ulId = ulId;
		this.userId = userId;
		this.doName = doName;
		this.doCtime = doCtime;
		this.userInfo = userInfo;
		this.dictInfo = dictInfo;
	}

	public UserLog() {
		super();
	}

	public Long getUlId() {
		return ulId;
	}

	public void setUlId(Long ulId) {
		this.ulId = ulId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDoName() {
		return doName;
	}

	public void setDoName(Long doName) {
		this.doName = doName;
	}

	public Date getDoCtime() {
		return doCtime;
	}

	public void setDoCtime(Date doCtime) {
		this.doCtime = doCtime;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public DictInfo getDictInfo() {
		return dictInfo;
	}

	public void setDictInfo(DictInfo dictInfo) {
		this.dictInfo = dictInfo;
	}
		
}
