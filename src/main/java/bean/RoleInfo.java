package bean;

import java.sql.Date;

public class RoleInfo {
	private Long roleId;
	private String roleName;
	private Date roleCtime;
	private Long roleState;

	public RoleInfo(Long roleId, String roleName, Date roleCtime, Long roleState) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleCtime = roleCtime;
		this.roleState = roleState;
	}

	public RoleInfo() {
		super();
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getRoleCtime() {
		return roleCtime;
	}

	public void setRoleCtime(Date roleCtime) {
		this.roleCtime = roleCtime;
	}

	public Long getRoleState() {
		return roleState;
	}

	public void setRoleState(Long roleState) {
		this.roleState = roleState;
	}

}
