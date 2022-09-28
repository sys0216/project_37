package course;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Courses;


@WebServlet("/courseList.do")
public class CourseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CourseListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Get으로 처리한다. 정보를 '가져오는' 것이기 때문.
	//DB에서 정보를 가져와야 하는데, 아직 이 프로젝트는 DB와 연결되지 않았다.
	//따라서 우선 이 파일은 그대로 두고, DTO, DAO 파일을 만들어야 한다.
	
		DBExpert dbe = new DBExpert();
		ArrayList<Courses> list = dbe.getAllCourse();
		int count = dbe.getCourseCount();
		request.setAttribute("CLIST", list);
		request.setAttribute("COUNT", count);
		RequestDispatcher rd =
				request.getRequestDispatcher("courseList.jsp");
		rd.forward(request,response);
		
	}
	
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
