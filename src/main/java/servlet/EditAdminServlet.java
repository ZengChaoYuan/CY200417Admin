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
 * Servlet implementation class EditAdminServlet
 */
@WebServlet("/EditAdminServlet")
public class EditAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAdminServlet() {
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
		String adminIds=request.getParameter("editId");
		Long adminId=Long.parseLong(adminIds);
		String adminName=request.getParameter("editName");	
		String adminPwd=request.getParameter("editPwd");
		String roleIds=request.getParameter("editRoleId");
		Long roleId=Long.parseLong(roleIds);
		AdminInfo admin=new AdminInfo();
		admin.setAdminId(adminId);
		admin.setAdminName(adminName);
		admin.setAdminPwd(adminPwd);
		admin.setRoleId(roleId);
		AdminInfoServiceImpl impl=new AdminInfoServiceImpl();
		Integer index=impl.updateAdminAllInfo(admin);
		JsonMessage msg=new JsonMessage();
		msg.setId(index);
		msg.setMsg(index==0?"修改失败!":"修改成功!");
		response.getWriter().println(JSONObject.toJSONString(msg));
	}

}
