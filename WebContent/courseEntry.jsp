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
	<h1 align="center">���� ��û ����� ����Ʈ</h1>
</header>
<section>
<div align="center"><h2>������ �߰�</h2></div>
<%
	ArrayList<String> names =
	(ArrayList<String>)request.getAttribute("NAMES");
%>
<form action="courseEntry.do" method="post">
	<table border="1" align="center">
		<tr><th>������ �ڵ�</th><td><input type="text" name="CODE"/></td></tr>
		<tr><th>�����</th><td><input type="text" name="NAME"/></td></tr>
		<tr><th>��簭��</th><td><select name="LEC">
		<%
			for(String name : names){
		%>
			<option><%= name %></option>
		<%
		}
		%>
		</select></td></tr>
		<tr><th>����</th><td><input type="text" name="CREDIT"/></td></tr>
		<tr><th>����</th>
		<td>��<input type="radio" name="WEEK" value="1"/>
		ȭ<input type="radio" name="WEEK" value="2"/>
		��<input type="radio" name="WEEK" value="3"/>
		��<input type="radio" name="WEEK" value="4"/>
		��<input type="radio" name="WEEK" value="5"/>
		��<input type="radio" name="WEEK" value="6"/></td></tr>
		<tr><th>���۽ð�</th><td><input type="text" name="START"/></td></tr>
		<tr><th>����ð�</th><td><input type="text" name="END"/></td></tr>
		<tr><td colspan="2" align="center">
			<input type="button" value="���" onclick="courseList()"/>
			<input type="submit" value="�Ϸ�" ></td></tr>
	</table>
</form>
<script type="text/javascript">
	function courseList(){
		location.href = "courseList.do";
	}
</script>
</section>
<footer>
	<h3 align="center">Copyright ����ó�������� All Right Reserved</h3>
</footer>
</body>
</html>