package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import bean.FileCheckInfo;
import bean.JsonMessage;
import service.FileCheckInfoServiceImpl;

/**
 * Servlet implementation class FileCheckPageServlet
 */
public class FileCheckPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileCheckPageServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String fileName=request.getParameter("fileName");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String ftIds=request.getParameter("ftId");
		Long ftId=Long.parseLong(ftIds);
		String start=request.getParameter("start");
		String limit=request.getParameter("limit");
		FileCheckInfoServiceImpl impl=new FileCheckInfoServiceImpl();
		List<FileCheckInfo> fileCheckInfo=impl.selectPage(fileName, startTime, endTime, ftId, start, limit);
		Long count=impl.countPage(fileName, startTime, endTime, ftId);
		JsonMessage msg=new JsonMessage();
		msg.getDataList().put("fileCheckInfo", fileCheckInfo);
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
