package bean;

import java.util.HashMap;
import java.util.Map;

public class JsonMessage {
	private int id;
	private String msg;
	private String location;
	private Map<String, Object> dataList = new HashMap<String, Object>();

	public JsonMessage(int id, String msg, String location, Map<String, Object> dataList) {
		super();
		this.id = id;
		this.msg = msg;
		this.location = location;
		this.dataList = dataList;
	}

	public JsonMessage() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Map<String, Object> getDataList() {
		return dataList;
	}

	public void setDataList(Map<String, Object> dataList) {
		this.dataList = dataList;
	}

}
