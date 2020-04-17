package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import bean.FileType;
import bean.JsonMessage;
import service.FileTypeServiceImpl;

/**
 * Servlet implementation class AddFileTypeServlet
 */
public class AddFileTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFileTypeServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String addTypeName=request.getParameter("addTypeName");	
		String addTailName=request.getParameter("addTailName");
		String addTypeScores=request.getParameter("addTypeScore");
		Long addTypeScore=Long.parseLong(addTypeScores);
		FileType fileType=new FileType();
		fileType.setTypeName(addTypeName);
		fileType.setTailName(addTailName);
		fileType.setTypeScore(addTypeScore);
		FileTypeServiceImpl impl=new FileTypeServiceImpl();
		Integer index=impl.insertFileType(fileType);
		JsonMessage msg=new JsonMessage();
		msg.setId(index);
		msg.setMsg(index==0?"新增失败!":"新增成功!");
		response.getWriter().println(JSONObject.toJSONString(msg));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
