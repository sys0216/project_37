package course;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/entryCourse.do")
public class EntryCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EntryCourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBExpert dbe = new DBExpert();
		ArrayList<String> list = dbe.getLecturerNmae();
		request.setAttribute("NAMES", list);
		RequestDispatcher rd =
				request.getRequestDispatcher("courseEntry.jsp");
		//" " 속 JSP 파일로 넘겨준다는 뜻
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
