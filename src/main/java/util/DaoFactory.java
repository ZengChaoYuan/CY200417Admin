package util;

import java.util.HashMap;
import java.util.Map;

import dao.AdminInfoDao;
import dao.AdminInfoDaoImpl;
import dao.MenuDao;
import dao.MenuDaoImpl;


public class DaoFactory {
	 
		private static Map<String,Object> config=new HashMap<String,Object>();
		
		static {
			config.put(AdminInfoDao.class.getName(),new AdminInfoDaoImpl());
			config.put(MenuDao.class.getName(), new MenuDaoImpl());
		}
		
		public static Object getDaoImpl(String name) {
			return config.get(name);
		}
}
