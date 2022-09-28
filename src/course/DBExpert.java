package course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Courses;

public class DBExpert {
	//DTO 파일.
	//DB로부터 정보를 가져와 관리하는데 사용한다.
	
	final String driver = "oracle.jdbc.OracleDriver";
	final String url = "jdbc:oracle:thin:@//localhost:1521/XE";
	final String id = "hr";
	final String pw = "hr";
	
	//여덟번째(과목 검색)
	public Courses getCourses(String id) {
		String select = "select c.id, c.name, l.name, "
				+ "c.credit,"
				+ "	c.week, c.start_hour, c.end_end"
				+ " from course_tbl c, lecturer_tbl l "
				+ "where c.lecturer = l.idx and c.id = ?";
		//어떤 강의를 선택했는지 검색하는 것
		Courses c = null;
		Connection con=null; PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {Class.forName(driver);
		con=DriverManager.getConnection(url,"hr",pw);
		pstmt=con.prepareStatement(select);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			c = new Courses();
			c.setId(rs.getString(1));
			c.setC_name(rs.getString(2));
			c.setL_name(rs.getString(3));
			c.setCredit(rs.getInt(4));
			c.setDay(rs.getInt(5));
			c.setStart_hour(rs.getInt(6));
			c.setStart(String.format("%04d", c.getStart_hour()));
			c.setEnd_hour(rs.getInt(7));
			c.setEnd(String.format("%04d", c.getEnd_hour()));
		}//if종료문
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close(); pstmt.close(); rs.close();
			}catch(Exception e) {}
		}
		return c;
	}
	
	
	//일곱번째(업데이트)
	public boolean courseUpdate(Courses c) {
		String update = "update course_tbl set name=?, "
				+ "credit=?, lecturer=?, week=?, "
				+ "start_hour=?, end_end=? "
				+ "where id =?";
		boolean flag = false;
		Connection con = null; PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,id,pw);
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, c.getC_name());
			pstmt.setInt(2, c.getCredit());
			pstmt.setString(3, c.getL_code());
			pstmt.setInt(4, c.getDay());
			pstmt.setInt(5, c.getStart_hour());
			pstmt.setInt(6, c.getEnd_hour());
			pstmt.setString(7, c.getId());
			pstmt.executeUpdate();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close(); pstmt.close();
			}catch(Exception e) {}
		}
		return flag;
	}
	

	//여섯번째(삭제)
	public boolean deleteCourse(String id) {
		String delete = "delete from course_tbl where id = ?";
		boolean flag = false;
		Connection con = null; PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr",pw);
			pstmt = con.prepareStatement(delete);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			con.commit();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close(); pstmt.close();
			}catch(Exception e) {}
		}
		return flag;
	}
	
	
	//다섯번째
	public boolean putCourse(Courses c) {
		String insert = "insert into course_tbl values("
				+ "?,?,?,?,?,?,?)";
		boolean flag = false;
		Connection con=null; PreparedStatement pstmt=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,id,pw);
			pstmt=con.prepareStatement(insert);
			pstmt.setString(1, c.getId());
			pstmt.setString(2, c.getC_name());
			pstmt.setInt(3, c.getCredit());
			pstmt.setString(4, c.getL_code());
			pstmt.setInt(5, c.getDay());
			pstmt.setInt(6, c.getStart_hour());
			pstmt.setInt(7, c.getEnd_hour());
			pstmt.executeUpdate();
			con.commit(); //commit; 실행
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return flag;
	}
	
	
	//네번째
	public int getLecturerCode(String name) {
		String select = "select idx from lecturer_tbl where "
				+ "name=?";
		int idx = -1;
		Connection con=null; PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,id,pw);
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) idx = rs.getInt(1);
		}catch(Exception e) {
					e.printStackTrace();
		}finally {
				try {
					rs.close(); pstmt.close(); con.close();
				}catch(Exception e) {}
			}
		return idx;
	}
	
	
	//세번째
	public ArrayList<String> getLecturerNmae(){
		String select = "select name from lecturer_tbl";
		ArrayList<String> list = new ArrayList<String>();
		Connection con=null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,id,pw);
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString(1);
				list.add(name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	
	//두번째
	public int getCourseCount() {
		String select = "select count(*) from course_tbl";
		//몇개의 데이터가 들어있는지 세어보는 것
		int result = -1;
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,id,pw);
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}

	//첫번째
	public ArrayList<Courses> getAllCourse(){
		String select="select c.id, c.name, c.credit, "
				+ "l.name, c.week, "
				+ "c.start_hour, c.end_end "
				+ "from course_tbl c, lecturer_tbl l "
				+ "where c.lecturer = l.idx";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Courses> list = new ArrayList<Courses>(); //조회결과 처리용
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,id,pw);
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Courses c = new Courses(); //DTO실행
				c.setId(rs.getString(1));
				c.setC_name(rs.getString(2));
				c.setCredit(rs.getInt(3));
				c.setL_name(rs.getString(4));
				c.setDay(rs.getInt(5));
				switch(c.getDay()) {//요일(숫자로 처리)
					case 1: c.setWeek("월"); break;
					case 2: c.setWeek("화"); break;
					case 3: c.setWeek("수"); break;
					case 4: c.setWeek("목"); break;
					case 5: c.setWeek("금"); break;
					case 6: c.setWeek("토"); break;
				}
				c.setStart_hour(rs.getInt(6));
				c.setStart(String.format("%04d", c.getStart_hour()));
				//시작 시간 앞에 "0"을 넣기 위해 적음
				c.setEnd_hour(rs.getInt(7));
				c.setEnd(String.format("%04d", c.getEnd_hour()));
				list.add(c);//여기까지의 데이터를 List에 더함
			}//while 끝
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
}
