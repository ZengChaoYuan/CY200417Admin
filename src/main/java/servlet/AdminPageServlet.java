package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import bean.AdminInfo;
import bean.JsonMessage;
import service.AdminInfoServiceImpl;

/**
 * Servlet implementation class AdminPageServlet
 */
@WebServlet("/AdminPageServlet")
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageServlet() {
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
		String adminName=request.getParameter("adminName");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String roleId=request.getParameter("roleId");
		String adminStates=request.getParameter("adminState");
		Long adminState=Long.parseLong(adminStates);
		String start=request.getParameter("start");
		String limit=request.getParameter("limit");
		AdminInfoServiceImpl impl=new AdminInfoServiceImpl();
		List<AdminInfo> admins=impl.selectPage(adminName, startTime, endTime, roleId,adminState, start, limit);
		Long count=impl.countPage(adminName, startTime, endTime, roleId,adminState);
		JsonMessage msg=new JsonMessage();
		msg.getDataList().put("admins", admins);
		msg.getDataList().put("count", count);
		response.getWriter().println(JSONObject.toJSONString(msg));
		
	}

}
