package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import bean.JsonMessage;
import bean.RoleInfo;
import service.RoleInfoService;
import service.RoleInfoServiceImpl;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleServlet() {
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
		//循环出所有的角色，不带分页
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		RoleInfoService impl=new RoleInfoServiceImpl();
		List<RoleInfo>roles=impl.selectAllRole();
		JsonMessage msg=new JsonMessage();
		msg.getDataList().put("roles", roles);
		response.getWriter().println(JSONObject.toJSONString(msg));
	}

}
