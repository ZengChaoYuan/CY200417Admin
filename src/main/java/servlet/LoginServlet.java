package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import bean.AdminInfo;
import bean.JsonMessage;
import service.AdminInfoService;
import util.ServiceFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	}
	private static Logger logger = Logger.getLogger(LoginServlet.class);    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		logger.debug("这是管理员登录的doPost");
		String name=request.getParameter("adminName");
		String pwd=request.getParameter("password");	
		String code=request.getParameter("code");
		String sessionCode=(String)request.getSession().getAttribute("code");
		JsonMessage msg=new JsonMessage(); 
		if(!code.equals(sessionCode)) {
			msg.setId(1);
			msg.setMsg("验证码错误！");
		}else {
			AdminInfoService adminService=(AdminInfoService)ServiceFactory.getServiceImpl(AdminInfoService.class.getName());
			AdminInfo adminInfo=adminService.login(name, pwd);
			if(adminInfo != null) {
				Long useState=adminInfo.getAdminState();
		        if(useState != 1){
		        	msg.setId(2);
					msg.setMsg("此用户被禁用！");
				}else {
					request.getSession().setAttribute("adminInfo", adminInfo);
					msg.setId(3);
					msg.setMsg("登录成功！");
					msg.setLocation("adminMain");
				}	
			}else {
				msg.setId(4);
				msg.setMsg("用户名或者密码错误！");			
			}
		}
		
		     
		String json=JSONObject.toJSONString(msg);
		response.getWriter().println(json);
	}

}
