<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String r = request.getParameter("R");
	if(r.equals("Y")){
%>
	<script type="text/javascript">
		alert("과목이 삭제되었습니다.");
	</script>
<%
	}else {
%>
	<script type="text/javascript">
		alert("과목이 삭제되지 않았습니다. 관리자에게 문의하세요.");
	</script>
<%	} %>
	<script type="text/javascript">
		location.href="courseList.do"; //목록으로 돌아가기
	</script>
</body>
</html>