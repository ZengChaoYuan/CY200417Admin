package bean;

import java.util.Date;

public class FileInfo {
	private Long fileId;
	private String fileName;
	private Date upCtime;
	private Long fileState;
	private Long typeId;
	private Long userId;
	private Long adminId;
	private String md5Code;
	private Long fileSize;
	private String savePath;
	private Long fileScore;

	public FileInfo(Long fileId, String fileName, Date upCtime, Long fileState, Long typeId, Long userId, Long adminId,
			String md5Code, Long fileSize, String savePath, Long fileScore) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.upCtime = upCtime;
		this.fileState = fileState;
		this.typeId = typeId;
		this.userId = userId;
		this.adminId = adminId;
		this.md5Code = md5Code;
		this.fileSize = fileSize;
		this.savePath = savePath;
		this.fileScore = fileScore;
	}

	public FileInfo() {
		super();
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getUpCtime() {
		return upCtime;
	}

	public void setUpCtime(Date upCtime) {
		this.upCtime = upCtime;
	}

	public Long getFileState() {
		return fileState;
	}

	public void setFileState(Long fileState) {
		this.fileState = fileState;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getMd5Code() {
		return md5Code;
	}

	public void setMd5Code(String md5Code) {
		this.md5Code = md5Code;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public Long getFileScore() {
		return fileScore;
	}

	public void setFileScore(Long fileScore) {
		this.fileScore = fileScore;
	}

}
