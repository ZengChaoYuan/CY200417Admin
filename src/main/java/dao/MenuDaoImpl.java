package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Menu;

public class MenuDaoImpl implements MenuDao {

	@Override
	public List<Menu> selectMenu(Connection conn, Long roleId) {
		String sql="SELECT * FROM MENU_INFO A INNER JOIN ROLE_MENU_REL B ON A.MENU_ID=B.MENU_ID \r\n" + 
				" AND B.ROLE_ID=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setLong(1, roleId);
			ResultSet rs=ps.executeQuery();
			List<Menu> menus=new ArrayList<Menu>();
			while(rs.next()) {
				 Long menuId=rs.getLong("MENU_ID");
				 String menuName=rs.getString("MENU_NAME");
				 String menuUrl=rs.getString("MENU_URL");
				 Long pmenuId=rs.getLong("PMENU_ID");
				 String menuIcon=rs.getString("MENU_ICON");
				 Date menuCtime=rs.getDate("MENU_CTIME");
				 Long menuState=rs.getLong("MENU_STATE");
				 Menu menu=new Menu(menuId,menuName, menuUrl, pmenuId, menuIcon, menuCtime, menuState);
				 menus.add(menu);
			}
			return menus;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
