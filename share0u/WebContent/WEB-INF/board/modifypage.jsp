<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.share0u.domain.RecordVO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board/resultmodify?rid=${rid}" method="post">
		제목 <input type="text" name="title" value = "${title}"><br>
		<br> 
		내용 <textarea rows="10" cols="50" name="contents">${contents}</textarea>
		<br>
		<br> 
		첨부파일 <input type="file" name="file"><br> 
		${noticecheck}
		${sharecheck}
	<button>글 수정</button>
	</form>
</body>
</html>