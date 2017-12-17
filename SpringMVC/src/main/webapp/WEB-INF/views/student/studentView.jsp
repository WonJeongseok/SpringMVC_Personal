<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>student/studentView.jsp입니다.</h1>

이름 : ${studentInfo.name}
나이 : ${studentInfo.age}
학년 : ${studentInfo.gradeNum}
반 : ${studentInfo.classNum}

	<a href="http://localhost:8080/springmvc/">뒤로가기</a>

</body>
</html>