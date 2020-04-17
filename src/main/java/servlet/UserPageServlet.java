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
import bean.UserInfo;
import service.UserInfoServiceImpl;

/**
 * Servlet implementation class UserPageServlet
 */
@WebServlet("/UserPageServlet")
public class UserPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPageServlet() {
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
		String userName=request.getParameter("userName");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String userTel=request.getParameter("userTel");
		String start=request.getParameter("start");
		String limit=request.getParameter("limit");
		UserInfoServiceImpl impl=new UserInfoServiceImpl();
		List<UserInfo> users=impl.selectPage(userName, startTime, endTime, userTel, start, limit);
		Long count=impl.countPage(userName, startTime, endTime, userTel);
		JsonMessage msg=new JsonMessage();
		msg.getDataList().put("users", users);
		msg.getDataList().put("count", count);
		response.getWriter().println(JSONObject.toJSONString(msg));
	}

}
