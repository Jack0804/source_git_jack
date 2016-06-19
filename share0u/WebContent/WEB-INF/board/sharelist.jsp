<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.share0u.domain.RecordVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "/board/mylist" method ="get">
		<button> 개인 페이지 </button><br>
	</form>
	공유글
	<table border="1">
	<tr>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>추천수</td>
			<td>조회수</td>
			<td>날짜</td>
	</tr>
		<c:forEach items="${search}" var="searchresult">
			<tr>
				<td><a href="/board/viewpage?rid=${searchresult.rid}">${searchresult.rtitle}</a></td>
				<td><a href="/board/viewpage?rid=${searchresult.rid}">${searchresult.rcontent}</a></td>
				<td><a href="/board/viewpage?rid=${searchresult.rid}">${searchresult.mid}</a></td>
				<td><a href="/board/viewpage?rid=${searchresult.rid}">${searchresult.rpoint}</a></td>
				<td><a href="/board/viewpage?rid=${searchresult.rid}">${searchresult.rhits}</a></td>
				<td><a href="/board/viewpage?rid=${searchresult.rid}">${searchresult.modifydate}</a></td>
			</tr>			
		</c:forEach>
	</table>
	
	<form method = "get">
	
	<select name = "select">
	<option value ="recent">최신순</option>
	<option value ="hits">조회순</option>
	<option value ="recommend">추천순</option>
	</select>
	<input type ="text" name = "searchtext">
	<button>검색</button>
	
	</form>
	
</body>
</html>