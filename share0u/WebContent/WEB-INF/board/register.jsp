<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 등록 페이지</h1>
	
	<form action="/board/resultmylist" method="post">
		제목 <input type="text" name ="title"><br><br>
		내용 <textarea rows="10" cols="50" name = "contents"></textarea><br><br>
	
		첨부파일 <input type = "file" name ="file"><br>
		${noticecheck}
		${sharecheck}
	<button>글 등록</button>
	</form>
	
</body>
</html>