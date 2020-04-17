package util;

import java.util.HashMap;
import java.util.Map;
import service.AdminInfoService;
import service.AdminInfoServiceImpl;
import service.MenuService;
import service.MenuServiceImpl;

public class ServiceFactory {
	private static Map<String,Object> config=new HashMap<String,Object>();
    static {
    	config.put(AdminInfoService.class.getName(), new AdminInfoServiceImpl());
    	config.put(MenuService.class.getName(), new MenuServiceImpl());
    }
    public static Object getServiceImpl(String name) {
    	return config.get(name);
    }
}


