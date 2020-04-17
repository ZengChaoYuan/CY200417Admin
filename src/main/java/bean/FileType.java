package bean;

import java.util.Date;

public class FileType {
	private Long ftId;
	private String typeName;
	private String tailName;
	private Long typeScore;
	private Date typeCtime;

	public FileType(Long ftId, String typeName, String tailName, Long typeScore, Date typeCtime) {
		super();
		this.ftId = ftId;
		this.typeName = typeName;
		this.tailName = tailName;
		this.typeScore = typeScore;
		this.typeCtime = typeCtime;
	}

	public FileType() {
		super();
	}

	public Long getFtId() {
		return ftId;
	}

	public void setFtId(Long ftId) {
		this.ftId = ftId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTailName() {
		return tailName;
	}

	public void setTailName(String tailName) {
		this.tailName = tailName;
	}

	public Long getTypeScore() {
		return typeScore;
	}

	public void setTypeScore(Long typeScore) {
		this.typeScore = typeScore;
	}

	public Date getTypeCtime() {
		return typeCtime;
	}

	public void setTypeCtime(Date typeCtime) {
		this.typeCtime = typeCtime;
	}

}
