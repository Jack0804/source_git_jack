<%@page import="org.share0u.domain.RecordVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@include file="../include/header.jsp" %>

	<h1>내가 작성한 글</h1>
		<table border="1" class="t">
		<tr>
			<td>제목</td>
			<td>내용</td>
			<td>날짜</td>
			<td>공유 여부</td>
		</tr>
	<c:forEach items="${myresult}" var="myresult">
		<tr>
			<td> <a href ="/board/viewpage?rid=${myresult.rid}"> ${myresult.rtitle}</a></td>
			<td> <a href ="/board/viewpage?rid=${myresult.rid}"> ${myresult.rcontent}</a></td>
			<td> <a href ="/board/viewpage?rid=${myresult.rid}"> ${myresult.modifydate}</a></td>
			<td> <a href ="/board/viewpage?rid=${myresult.rid}"> ${myresult.rshare}</a></td>
		</tr>
		
	</c:forEach>
				
	</table>
	
	${pagelist}
	
	<form action="/board/register" method="get">
		<button>게시물등록</button>
	</form>
	
<%@include file="../include/footer.jsp" %>