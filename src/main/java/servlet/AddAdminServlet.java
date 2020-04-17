package servlet;

import java.io.IOException;
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
 * Servlet implementation class AddAdminServlet
 */
@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminServlet() {
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
		String adminName=request.getParameter("addName");	
		String adminPwd=request.getParameter("addPwd");
		String roleIds=request.getParameter("addRoleId");
		Long roleId=Long.parseLong(roleIds);
		AdminInfo admin=new AdminInfo();
		admin.setAdminName(adminName);
		admin.setAdminPwd(adminPwd);
		admin.setRoleId(roleId);
		AdminInfoServiceImpl impl=new AdminInfoServiceImpl();
		Integer index=impl.insertByAdmin(admin);
		JsonMessage msg=new JsonMessage();
		msg.setId(index);
		msg.setMsg(index==0?"新增失败!":"新增成功!");
		response.getWriter().println(JSONObject.toJSONString(msg));
	}

}
