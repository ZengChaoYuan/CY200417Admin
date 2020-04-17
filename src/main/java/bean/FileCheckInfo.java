package bean;

import java.sql.Date;

public class FileCheckInfo {//文件审核界面三表连表查询：文件审查表+文件信息表+文件类型表
	private Long fcId;
	private Long fileId;
	private Long checkState;
	private Date checkCtime;
	private Long adminId;
	private FileInfo fileInfo;
	private FileType fileType;
		
	public FileCheckInfo(Long fcId, Long fileId, Long checkState, Date checkCtime, Long adminId) {
		super();
		this.fcId = fcId;
		this.fileId = fileId;
		this.checkState = checkState;
		this.checkCtime = checkCtime;
		this.adminId = adminId;
	}

	public FileCheckInfo() {
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

	public FileInfo getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}
	
}
