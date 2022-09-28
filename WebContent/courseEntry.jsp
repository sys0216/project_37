<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
	<h1 align="center">수강 신청 도우미 사이트</h1>
</header>
<section>
<div align="center"><h2>교과목 추가</h2></div>
<%
	ArrayList<String> names =
	(ArrayList<String>)request.getAttribute("NAMES");
%>
<form action="courseEntry.do" method="post">
	<table border="1" align="center">
		<tr><th>교과목 코드</th><td><input type="text" name="CODE"/></td></tr>
		<tr><th>과목명</th><td><input type="text" name="NAME"/></td></tr>
		<tr><th>담당강사</th><td><select name="LEC">
		<%
			for(String name : names){
		%>
			<option><%= name %></option>
		<%
		}
		%>
		</select></td></tr>
		<tr><th>학점</th><td><input type="text" name="CREDIT"/></td></tr>
		<tr><th>요일</th>
		<td>월<input type="radio" name="WEEK" value="1"/>
		화<input type="radio" name="WEEK" value="2"/>
		수<input type="radio" name="WEEK" value="3"/>
		목<input type="radio" name="WEEK" value="4"/>
		금<input type="radio" name="WEEK" value="5"/>
		토<input type="radio" name="WEEK" value="6"/></td></tr>
		<tr><th>시작시간</th><td><input type="text" name="START"/></td></tr>
		<tr><th>종료시간</th><td><input type="text" name="END"/></td></tr>
		<tr><td colspan="2" align="center">
			<input type="button" value="목록" onclick="courseList()"/>
			<input type="submit" value="완료" ></td></tr>
	</table>
</form>
<script type="text/javascript">
	function courseList(){
		location.href = "courseList.do";
	}
</script>
</section>
<footer>
	<h3 align="center">Copyright 정보처리산업기사 All Right Reserved</h3>
</footer>
</body>
</html>