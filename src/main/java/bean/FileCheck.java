package bean;

import java.util.Date;

public class FileCheck {
	private Long fcId;
	private Long fileId;
	private Long checkState;
	private Date checkCtime;
	private Long adminId;

	public FileCheck(Long fcId, Long fileId, Long checkState, Date checkCtime, Long adminId) {
		super();
		this.fcId = fcId;
		this.fileId = fileId;
		this.checkState = checkState;
		this.checkCtime = checkCtime;
		this.adminId = adminId;
	}

	public FileCheck() {
		super();
	}

	public Long getFcId() {
		return fcId;
	}

	public void setFcId(Long fcId) {
		this.fcId = fcId;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public Long getCheckState() {
		return checkState;
	}

	public void setCheckState(Long checkState) {
		this.checkState = checkState;
	}

	public Date getCheckCtime() {
		return checkCtime;
	}

	public void setCheckCtime(Date checkCtime) {
		this.checkCtime = checkCtime;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

}
