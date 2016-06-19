<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<form action="/member/loginresult" method="post">

			<img alt="" src="../../images/4.jpg"><br />
			<br /> ID<input type="text" name="id"><br /> 
			PW<input type="password" name="pw"><br />
			<button>로그인</button>
			
			
	</form>
	<form action="/member/register" method="get">
		<button>회원가입</button>
	</form>




</body>
</html>