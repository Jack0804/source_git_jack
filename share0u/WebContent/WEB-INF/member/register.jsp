<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<form action="/member/result" method = "post">
		<h1> Test Register </h1>
		ID 		: <input type ="text" name = "mid"><br>
		PW 		: <input type ="text" name = "mpw"><br>
		이름 	: <input type ="text" name = "mname"><br>
		역할		: <input type ="text" name = "mrole"><br>
		
		<button> 회원가입 완료 </button>
	</form>
</body>
</html>