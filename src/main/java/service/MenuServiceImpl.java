package service;

import java.sql.Connection;
import java.util.List;

import bean.Menu;
import dao.MenuDao;
import util.DBUtil;
import util.DaoFactory;

public class MenuServiceImpl implements MenuService {

	@Override
	public List<Menu> selectMenu(Long roleId) {
		Connection conn=DBUtil.getConnection();
		MenuDao menuDao=(MenuDao)DaoFactory.getDaoImpl(MenuDao.class.getName());
		return menuDao.selectMenu(conn, roleId);
	}

}
