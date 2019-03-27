package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comments.Comments;
import comments.CommentsDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class EmpjsonServ
 */
@WebServlet("/EmpjsonServ")
public class EmpjsonServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//요청한 파라미터(id)를 dto의 setEmployee_id에 저장
		EmpDTO dto = new EmpDTO();
		dto.setEmployee_id(request.getParameter("id"));
		
		//위에서 저장된 dto값을 selectOne(selectOne함수의 return타입이 dto임)에 넣어 EmpDAO에 getInstance()한 후 EmpDTO타입의 result변수에 저장
		EmpDTO result = EmpDAO.getInstance().selectOne(dto);
		out.print(JSONObject.fromObject(result));
	}
}

