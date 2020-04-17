package service;

import java.sql.Connection;
import java.util.List;

import bean.Menu;

public interface MenuService {
	//通过角色找到菜单信息
	 List<Menu> selectMenu(Long roleId);
}
