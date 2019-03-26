package comments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class CommentsJsonServ
 */
@WebServlet("/CommentsJsonServ")
public class CommentsJsonServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String cmd = request.getParameter("cmd");
		if(cmd.equals("selectAll")) {
			//목록처리
			try {
				List<HashMap<String, Object>> list = CommentsDAO.getInstance().selectAll();
				out.print(JSONArray.fromObject(list));
			} catch (Exception e) {
				e.printStackTrace();
			}
		//등록처리
		} else if(cmd.equals("insert")) {
			try {
				//빈을 생성해서 파라미터를 빈에 담기
				Comments bean = new Comments();
				bean.setContent(request.getParameter("content"));
				bean.setName(request.getParameter("name"));
				
				HashMap<String, Object> map = CommentsDAO.getInstance().insert(bean);
				//JSONArray.fromObject메소드를 사용해서 JSON타입으로 변환해서 출력하기
				out.print(JSONArray.fromObject(map));
			} catch (Exception e) {
				e.printStackTrace();
				//out.print(toXML("error", e.getMessage()));
			}
		}
	}
}
