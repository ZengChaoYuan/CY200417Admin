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
 * Servlet implementation class EditAdminUseStateServlet
 */
@WebServlet("/EditAdminUseStateServlet")
public class EditAdminUseStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAdminUseStateServlet() {
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
		String adminIds=request.getParameter("adminId");
		Long adminId=Long.parseLong(adminIds);
		AdminInfoServiceImpl impl=new AdminInfoServiceImpl();
		AdminInfo admin=impl.selectAdminInfoById(adminId);
		Long useState=admin.getAdminState();
		if(useState==1) {
			admin.setAdminState(2L);
			Integer index=impl.updateAdminUseState(admin);
			JsonMessage msg=new JsonMessage();
			msg.setId(index);
			msg.setMsg(index==0?"禁用失败!":"禁用成功!");
			response.getWriter().println(JSONObject.toJSONString(msg));
			
		}else{
			admin.setAdminState(1L);
			Integer index=impl.updateAdminUseState(admin);
			JsonMessage msg=new JsonMessage();
			msg.setId(index);
			msg.setMsg(index==0?"启用失败!":"启用成功!");
			response.getWriter().println(JSONObject.toJSONString(msg));	
		}
	}

}
