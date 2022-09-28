<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<header>
	<h1 align="center">수강 신청 도우미 사이트</h1>
</header>
<section>
<%
	ArrayList<Courses> clist = 
		(ArrayList<Courses>)request.getAttribute("CLIST");
	int cnt = (int)request.getAttribute("COUNT");
%>
	<!-- servlet에서 보낸 데이터들을 먼저 받음 -->
<div aling="left">총 <%= cnt %>개의 교과목이 있습니다.</div>
<table border="1">
	<tr><th>과목코드</th><th>과목명</th><th>학점</th>
		<th>담당강사</th><th>요일</th><th>시작시간</th>
		<th>종료시간</th><th>관리</th></tr>

<%
	for(Courses c : clist){
	//for(변수 : 배열이나 CF) { 명령문; } 
%>
	<form action="courseUpdate.do" method="post">
	<!-- 데이터를 수정, 업데이트 하는데 사용해야하니까 Post 사용 -->
	
	<input type="hidden" name="ID" value="<%= c.getId() %>"/>
	<tr><td><%= c.getId() %></td><td><%= c.getC_name() %></td>
		<td><%= c.getCredit() %></td>
		<td><%= c.getL_name() %></td>
		<td><%= c.getWeek() %></td>
		<td><%= c.getStart() %></td><td><%= c.getEnd() %></td>
		<td><input type="submit" value="수정" name="BTN"/>
			<input type="submit" value="삭제" name="BTN"/></td></tr>
	</form>
<%
	}
%>
	<tr><td colspan="8" align="right">
		<form action="entryCourse.do">
			<input type="submit" value="작 성"/>
		</form></td></tr>
</table>
</section>
<footer>
	<h3 align="center">Copyright 정보처리산업기사 All Right Reserved</h3>
</footer>
</body>
</html>