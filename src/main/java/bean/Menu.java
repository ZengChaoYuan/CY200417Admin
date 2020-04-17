package bean;

import java.sql.Date;

public class Menu {
	private Long menuId;
	private String menuName;
	private String menuUrl;
	private Long pmenuId;
	private String menuIcon;
	private Date menuCtime;
	private Long menuState;

	public Menu(Long menuId, String menuName, String menuUrl, Long pmenuId, String menuIcon, Date menuCtime,
			Long menuState) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.pmenuId = pmenuId;
		this.menuIcon = menuIcon;
		this.menuCtime = menuCtime;
		this.menuState = menuState;
	}

	public Menu() {
		super();
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Long getPmenuId() {
		return pmenuId;
	}

	public void setPmenuId(Long pmenuId) {
		this.pmenuId = pmenuId;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Date getMenuCtime() {
		return menuCtime;
	}

	public void setMenuCtime(Date menuCtime) {
		this.menuCtime = menuCtime;
	}

	public Long getMenuState() {
		return menuState;
	}

	public void setMenuState(Long menuState) {
		this.menuState = menuState;
	}

}
