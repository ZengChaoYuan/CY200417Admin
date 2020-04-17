package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import bean.AdminInfo;
import bean.JsonMessage;
import bean.Menu;
import service.MenuService;
import util.ServiceFactory;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		//从session中取出登录存的用户对象
		AdminInfo info=(AdminInfo)session.getAttribute("adminInfo");
		//取出该用户对象的角色Id
		Long roleId=info.getRoleId();
		MenuService menuService=(MenuService)ServiceFactory.getServiceImpl(MenuService.class.getName());
		List<Menu> menus=menuService.selectMenu(roleId);
		JsonMessage msg=new JsonMessage();
		//HashMap
		msg.getDataList().put("menus", menus);
		response.getWriter().println(JSONObject.toJSONString(msg));
	}

}
