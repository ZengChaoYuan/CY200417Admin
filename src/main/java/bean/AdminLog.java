package bean;

import java.sql.Date;

public class AdminLog {// 管理员日志表:三表查询:管理员日志表+管理员表+字典表
	private Long alogId;
	private Long adminId;
	private Long doName;
	private Date doCtime;
	private AdminInfo adminInfo;
	private DictInfo dictInfo;

	public AdminLog(Long alogId, Long adminId, Long doName, Date doCtime) {
		super();
		this.alogId = alogId;
		this.adminId = adminId;
		this.doName = doName;
		this.doCtime = doCtime;
	}

	public AdminLog() {
		super();
	}

	public Long getAlogId() {
		return alogId;
	}

	public void setAlogId(Long alogId) {
		this.alogId = alogId;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
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

	public AdminInfo getAdminInfo() {
		return adminInfo;
	}

	public void setAdminInfo(AdminInfo adminInfo) {
		this.adminInfo = adminInfo;
	}

	public DictInfo getDictInfo() {
		return dictInfo;
	}

	public void setDictInfo(DictInfo dictInfo) {
		this.dictInfo = dictInfo;
	}

}
