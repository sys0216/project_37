package course;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Courses;

@WebServlet("/courseEntry.do")
public class CourseEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CourseEntryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR"); //한글화 작업
		
		String code = request.getParameter("CODE");
		String name = request.getParameter("NAME");
		String lec = request.getParameter("LEC");
		String credit = request.getParameter("CREDIT");
		String week = request.getParameter("WEEK");
		String start = request.getParameter("START");
		String end = request.getParameter("END");
		
		Courses c = new Courses();
		//model 폴더 안에 있는 Courses (DTO 파일 실행)
		
		c.setId(code);
		c.setC_name(name);
		c.setCredit(Integer.parseInt(credit));
		
		DBExpert dbe = new DBExpert();
		//강사의 경우 입력하는 사람은 '강사의 이름'을 입력하지만,
		//데이터베이스에는 강사의 번호로 강사가 분류되어있다.
		//DBExpert에 새로운 객체를 생성해, 강사의 이름에 따른 강사 번호를 매치시켜주는 객체를 만들어 사용한다.
		//DBExpert.java 파일로 이동
		
		int l_code = dbe.getLecturerCode(lec); //Servlet에서 작업한 값 가져옴
		
		c.setL_code(String.valueOf(l_code));
		c.setDay(Integer.parseInt(week));
		c.setStart_hour(Integer.parseInt(start));
		c.setEnd_hour(Integer.parseInt(end));
		
		//데이터를 업데이트 하는 메소드를 DBExpert.java에서 생성, 이 곳에 매개변수로 끌고 온다.
		boolean result = dbe.putCourse(c);
		if(result) {//데이터 입력이 잘 되었을 때
			response.sendRedirect("entryResult.jsp?R=YES");
		}else {//데이터 입력이 잘 되지 않았을 때
			response.sendRedirect("entryResult.jsp?R=NO");
		}
		
	}

}
