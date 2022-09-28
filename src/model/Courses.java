package model;

public class Courses {
	private String id;
	private String c_name;
	//name은 course_tbl과 lecturer_tbl 둘 다 있으니 앞에 표시를 적어놓는게 좋다.
	private Integer credit;
	private String l_name;
	private String l_code;
	
	private String week;
	private Integer day;
	
	private String start;
	private Integer start_hour;
	
	private String end;
	private Integer end_hour;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getL_code() {
		return l_code;
	}
	public void setL_code(String l_code) {
		this.l_code = l_code;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public Integer getStart_hour() {
		return start_hour;
	}
	public void setStart_hour(Integer start_hour) {
		this.start_hour = start_hour;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Integer getEnd_hour() {
		return end_hour;
	}
	public void setEnd_hour(Integer end_hour) {
		this.end_hour = end_hour;
	}
}
