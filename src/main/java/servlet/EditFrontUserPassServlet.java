package servlet;

import java.io.IOException;
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
 * Servlet implementation class EditFrontUserPassServlet
 */
@WebServlet("/EditFrontUserPassServlet")
public class EditFrontUserPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFrontUserPassServlet() {
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
		String userIds=request.getParameter("userId");
		Long userId=Long.parseLong(userIds);
        String password="123456";
        UserInfo user=new UserInfo();
        user.setUserId(userId);
        user.setUserPwd(password);
		UserInfoServiceImpl impl=new UserInfoServiceImpl();
		Integer index=impl.updateUserPassword(user);
		JsonMessage msg=new JsonMessage();
		msg.setId(index);
		msg.setMsg(index==0?"修改密码失败!":"修改密码成功!");
		response.getWriter().println(JSONObject.toJSONString(msg));	
	}

}
