package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import bean.JsonMessage;
import bean.RoleInfo;
import service.RoleInfoServiceImpl;

/**
 * Servlet implementation class EditRoleUseStateServlet
 */
public class EditRoleUseStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRoleUseStateServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String roleIds=request.getParameter("roleId");
		Long roleId=Long.parseLong(roleIds);
		String roleStates=request.getParameter("roleState");
		Long roleState=Long.parseLong(roleStates);
		RoleInfo role=new RoleInfo();
		role.setRoleId(roleId);
		role.setRoleState(roleState);
		RoleInfoServiceImpl impl=new RoleInfoServiceImpl();
		Integer index=impl.updateRoleUseState(role);
		JsonMessage msg=new JsonMessage();
		msg.setId(index);
		msg.setMsg(index==0?"修改失败!":"修改成功!");
		response.getWriter().println(JSONObject.toJSONString(msg));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
