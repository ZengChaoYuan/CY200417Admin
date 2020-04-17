package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import bean.FileType;
import bean.JsonMessage;
import service.FileTypeServiceImpl;

/**
 * Servlet implementation class FileTypePageServlet
 */
public class FileTypePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileTypePageServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String typeName=request.getParameter("typeName");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String start=request.getParameter("start");
		String limit=request.getParameter("limit");
		FileTypeServiceImpl impl=new FileTypeServiceImpl();
		List<FileType> fileType=impl.selectPage(typeName, startTime, endTime, start, limit);
		Long count=impl.countPage(typeName, startTime, endTime);
		JsonMessage msg=new JsonMessage();
		msg.getDataList().put("fileType", fileType);
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
