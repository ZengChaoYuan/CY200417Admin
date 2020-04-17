package bean;

public class DictInfo {//字典表
	private Long dictId;
	private String code;
	private String name;
	private Long value;

	public DictInfo(Long dictId, String code, String name, Long value) {
		super();
		this.dictId = dictId;
		this.code = code;
		this.name = name;
		this.value = value;
	}

	public DictInfo() {
		super();
	}

	public Long getDictId() {
		return dictId;
	}

	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

}
