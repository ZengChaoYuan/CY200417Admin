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
 * Servlet implementation class EditFileTypeServlet
 */
public class EditFileTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFileTypeServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String ftIds=request.getParameter("ftId");
		Long ftId=Long.parseLong(ftIds);
		String typeName=request.getParameter("typeName");	
		String tailName=request.getParameter("tailName");	
		String typeScores=request.getParameter("typeScore");
		Long typeScore=Long.parseLong(typeScores);
		FileType fileType=new FileType();
		fileType.setFtId(ftId);
		fileType.setTypeName(typeName);
		fileType.setTailName(tailName);
		fileType.setTypeScore(typeScore);
		FileTypeServiceImpl impl=new FileTypeServiceImpl();
		Integer index=impl.updateFiletype(fileType);
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
