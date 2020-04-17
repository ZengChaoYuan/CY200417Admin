package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import bean.AdminLog;
import bean.JsonMessage;
import service.AdminLogServiceImpl;

/**
 * Servlet implementation class AdminLogPageServlet
 */
public class AdminLogPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogPageServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String adminName=request.getParameter("adminName");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String start=request.getParameter("start");
		String limit=request.getParameter("limit");
		AdminLogServiceImpl impl=new AdminLogServiceImpl();
		List<AdminLog> adminLog=impl.selectPage(adminName, startTime, endTime, start, limit);
		Long count=impl.countPage(adminName, startTime, endTime);
		JsonMessage msg=new JsonMessage();
		msg.getDataList().put("adminLog", adminLog);
		msg.getDataList().put("count", count);
		response.getWriter().println(JSONObject.toJSONString(msg));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
