package dao;

import java.sql.Connection;
import java.util.List;

import bean.Menu;



public interface MenuDao {
 //通过角色找到菜单信息
 List<Menu> selectMenu(Connection conn,Long roleId);
 
}
