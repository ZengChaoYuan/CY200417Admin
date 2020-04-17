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
 * Servlet implementation class EditUserUseStateServlet
 */
@WebServlet("/EditUserUseStateServlet")
public class EditUserUseStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserUseStateServlet() {
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
		UserInfoServiceImpl impl=new UserInfoServiceImpl();
		UserInfo user=impl.selectUserInfoById(userId);
		Long useState=user.getUserState();
		if(useState==1) {
			user.setUserState(2L);
			Integer index=impl.updateUserUseState(user);
			JsonMessage msg=new JsonMessage();
			msg.setId(index);
			msg.setMsg(index==0?"禁用失败!":"禁用成功!");
			response.getWriter().println(JSONObject.toJSONString(msg));
			
		}else{
			user.setUserState(1L);
			Integer index=impl.updateUserUseState(user);
			JsonMessage msg=new JsonMessage();
			msg.setId(index);
			msg.setMsg(index==0?"启用失败!":"启用成功!");
			response.getWriter().println(JSONObject.toJSONString(msg));	
		}
	}

}
