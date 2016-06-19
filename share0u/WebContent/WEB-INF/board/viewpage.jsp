<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<h1>상세 페이지</h1>
<div>추천수: ${point}</div>
<div>조회수:${hits}</div>
<div>제목:${title}</div>
<div>날짜:${date}</div>
<div>작성자:${writer}</div>
<div>내용:${contents}</div>
<button>다운로드</button>

${sharecheck}
${noticecheck}

${pagedelete}  
${pagemodify}
<form action="/board/pointresult">${pagepoint}</form>
<form action="/board/mylist"><button>목록으로</button></form>

	
</body>
</html>