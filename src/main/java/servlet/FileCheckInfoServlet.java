package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import bean.FileCheckInfo;
import bean.JsonMessage;
import service.FileCheckInfoServiceImpl;

/**
 * Servlet implementation class FileCheckInfoServlet
 */
@WebServlet("/FileCheckInfoServlet")
public class FileCheckInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileCheckInfoServlet() {
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
		FileCheckInfoServiceImpl impl=new FileCheckInfoServiceImpl();
		List<FileCheckInfo> fileCheck=impl.selectFileCheckList();
		JsonMessage msg=new JsonMessage();
		msg.getDataList().put("fileCheck", fileCheck);
		response.getWriter().println(JSONObject.toJSONString(msg));	
	}

}
